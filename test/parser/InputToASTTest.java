package parser;

import ast.Number;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.junit.Test;

import ast.*;

import static org.junit.Assert.assertEquals;

public class InputToASTTest {

    Program getTestProgram(String input) {

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        return (Program) parser.program().accept(visitor);
    }

    @Test
    public void diverseTest() {
        String input = """
                  ARENA:
                      size = 100;
                  ENTITIES:
                      define player mario {
                          start = 0,0;
                          health = 10;
                          size = 2;
                          direction = right;
                       }
                      define enemy goomba {
                          health = 8;
                          size = 1;
                          damage = 2;
                          direction = up;
                       }
                      define obstacle box {
                          start = 2,2;
                          size = 2;
                          direction = down;
                      }
                      define collectable coin {
                          start = 1,0;
                          size = 1;
                          direction = left;
                      }

                  BEHAVIOUR:
                      define function move_left_right() {
                          var count = 0;
                          forever unless (var count > 100) {
                              face right;
                              move 1;
                              wait 1 sec;
                              face left;
                              wait 1 sec;
                              set count = (var count + 1);
                          }
                      }
                      entity goomba {
                          call move_left_right(var test, 1);
                      }
                      entity coin {
                          wait 1 sec;
                          call move_left_right();
                      }

                  END_CRITERIA:
                      win:
                          var coin amount equals 10;
                      lose:
                          var mario health equals 0;""";

        Program parsedProgram = getTestProgram(input);

        // Check arena
        assertEquals(new Number(100), parsedProgram.getArena().getSize()); // 100 is illegal size - we do checks for size in evaluator
        //                                                                    Test pass is acceptable at this stage.

        // Check entities
        assertEquals(4, parsedProgram.getEntities().size());

        // Check mario
        Entity mario = parsedProgram.getEntities().get(0);
        assertEquals("mario", mario.getName());
        assertEquals(EntityType.PLAYER, mario.getType());
        assertEquals(new Pair<>(0, 0), mario.getStart());
        assertEquals((Integer) 2, mario.getSize());
        assertEquals((Integer) 10, mario.getHealth());
        assertEquals(Direction.RIGHT, mario.getDirection());
        assertEquals((Integer) 0, mario.getDamage());

        // Check Goomba
        Entity goomba = parsedProgram.getEntities().get(1);
        assertEquals("goomba", goomba.getName());
        assertEquals(EntityType.ENEMY, goomba.getType());
        assertEquals(new Pair<>(0, 0), goomba.getStart());
        assertEquals((Integer) 1, goomba.getSize());
        assertEquals((Integer) 8, goomba.getHealth());
        assertEquals(Direction.UP, goomba.getDirection());
        assertEquals((Integer) 2, goomba.getDamage());

        // Check Box
        Entity box = parsedProgram.getEntities().get(2);
        assertEquals("box", box.getName());
        assertEquals(EntityType.OBSTACLE, box.getType());
        assertEquals(new Pair<>(2, 2), box.getStart());
        assertEquals((Integer) 2, box.getSize());
        assertEquals((Integer) 1, box.getHealth());
        assertEquals(Direction.DOWN, box.getDirection());
        assertEquals((Integer) 0, box.getDamage());

        // Check Coin
        Entity coin = parsedProgram.getEntities().get(3);
        assertEquals("coin", coin.getName());
        assertEquals(EntityType.COLLECTABLE, coin.getType());
        assertEquals(new Pair<>(1, 0), coin.getStart());
        assertEquals((Integer) 1, coin.getSize());
        assertEquals((Integer) 1, coin.getHealth());
        assertEquals(Direction.LEFT, coin.getDirection());
        assertEquals((Integer) 0, coin.getDamage());

        // Check behaviours
        assertEquals(3, parsedProgram.getBehaviours().size());

        // Check end criteria
        assertEquals("coin", parsedProgram.getEndCriteria().getWinEntityName());
        assertEquals(EndCriteriaType.AMOUNT, parsedProgram.getEndCriteria().getWinType());
        assertEquals((Integer) 10, parsedProgram.getEndCriteria().getWinValue());

        assertEquals("mario", parsedProgram.getEndCriteria().getLoseEntityName());
        assertEquals(EndCriteriaType.HEALTH, parsedProgram.getEndCriteria().getLoseType());
        assertEquals((Integer) 0, parsedProgram.getEndCriteria().getLoseValue());
    }


    @Test
    public void simpleTest() {
        String input = "ARENA:\n" +
                "    size = 40;\n" +
                "\n" +
                "ENTITIES:\n" +
                "    define player mario {\n" +
                "        start = 0,0;\n" +
                "        health = 10;\n" +
                "        size = 2;\n" +
                "        direction = right;\n" +
                "     }\n" +
                "\n" +
                "BEHAVIOUR:\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario health equals 100;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        Program parsedProgram = getTestProgram(input);

        assertEquals(new Number(40), parsedProgram.getArena().getSize());

        assertEquals(1, parsedProgram.getEntities().size());

        Entity mario = parsedProgram.getEntities().get(0);
        assertEquals("mario", mario.getName());
        assertEquals(EntityType.PLAYER, mario.getType());
        assertEquals(new Pair<>(0, 0), mario.getStart());
        assertEquals((Integer) 2, mario.getSize());
        assertEquals((Integer) 10, mario.getHealth());
        assertEquals(Direction.RIGHT, mario.getDirection());
        assertEquals((Integer) 0, mario.getDamage());


        assertEquals(0, parsedProgram.getBehaviours().size());


//      Check end criteria
        assertEquals("mario", parsedProgram.getEndCriteria().getWinEntityName());
        assertEquals(EndCriteriaType.HEALTH, parsedProgram.getEndCriteria().getWinType());
        assertEquals((Integer) 100, parsedProgram.getEndCriteria().getWinValue());

        assertEquals("mario", parsedProgram.getEndCriteria().getLoseEntityName());
        assertEquals(EndCriteriaType.HEALTH, parsedProgram.getEndCriteria().getLoseType());
        assertEquals((Integer) 0, parsedProgram.getEndCriteria().getLoseValue());




    }






}