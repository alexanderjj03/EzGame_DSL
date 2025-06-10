package evaluator;

import Errors.ArenaTooLargeError;
import Errors.DuplicatePlayerDefinedError;
import Errors.EntityStartOutOfBounds;
import Errors.InvalidEntityError;
import ast.Direction;
import ast.Program;
import game.*;
import gamemaker.EZGameBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import parser.EZGameLexer;
import parser.EZGameParser;
import parser.ParseToASTVisitor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluatorTest {



    @Test
    public void simpleEvaluatorTest() {
        String input = "ARENA:\n" +
                "        size = 10;\n" +
                "ENTITIES: \n" +
                "        define player hero {\n" +
                "            start = 2,3;\n" +
                "            health = 100; \n" +
                "            size = 1; \n" +
                "            direction = up; \n" +
                "        }\n" +
                "        \n" +
                "BEHAVIOUR:\n" +
                "        entity hero { \n" +
                "            move 1; \n" +
                "            face left; \n" +
                "            wait 2 sec;\n" +
                "        } \n" +
                "        \n" +
                "END_CRITERIA: \n" +
                "        win: var hero amount equals 1;\n" +
                "        lose: var hero health equals 0;";



        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        TileMap game = builder.build();
        assertEquals(10, game.getCols());
        assertEquals(10, game.getRows());

        Player player = game.getPlayer();
        assertEquals(100, player.getHealth());
        assertEquals(1, player.getSize());
        assertEquals(2, player.getPosX());
        assertEquals(3, player.getPosY());

    }


    @Test
    public void evaluatorTestInfLoopTest() {
        String input = "ARENA:\n" +
                "    size = 40;\n" +
                "ENTITIES:\n" +
                "    define player hero {\n" +
                "        start = 5,5;\n" +
                "        health = 100;\n" +
                "        size = 1;\n" +
                "        direction = right;\n" +
                "    }\n" +
                "    define enemy goblin {\n" +
                "        start = 10,10;\n" +
                "        health = 50;\n" +
                "        size = 1;\n" +
                "        direction = left;\n" +
                "        damage = 10;\n" +
                "    }\n" +
                "    define obstacle wall {\n" +
                "        start = 7,7;\n" +
                "        size = 2;\n" +
                "    }\n" +
                "    define collectable coin {\n" +
                "        start = 1,2;\n" +
                "        size = 1;\n" +
                "    }\n" +
                "BEHAVIOUR:\n" +
                "    entity hero {\n" +
                "var enemy_nearby = 1;"+
                "        forever unless (var enemy_nearby equals 1) {\n" +
                "            move 1;\n" +
                "            wait 1 sec;\n" +
                "        }\n" +
                "    }\n" +
                "    entity goblin {\n" +
                "        forever unless (on pos 0,0) {\n" +
                "            move 1;\n" +
                "            face left;\n" +
                "            wait 2 sec;\n" +
                "        }\n" +
                "    }\n" +
                "END_CRITERIA:\n" +
                "    win: var coin amount equals 5;\n" +
                "    lose: var hero health equals 0;";



        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        for (Token token : lexer.getAllTokens()) {
            System.out.println(token);
        }

        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

        assertEquals("Maximum loop repetions reached", e.getMessage());

    }


    @Test
    public void goombaTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
                "\n" +
                "ENTITIES:\n" +
                "    define player mario {\n" +
                "        start = 0,0;\n" +
                "        health = 10;\n" +
                "        size = 2;\n" +
                "        direction = right;\n" +
                "     }\n" +
                "    define enemy goomba {\n" +
                "        health = 8;\n" +
                "        size = 1;\n" +
                "        damage = 2;\n" +
                "        direction = up;\n" +
                "     }\n" +
                "    define obstacle box {\n" +
                "        start = 2,2;\n" +
                "        size = 2;\n" +
                "        direction = down;\n" +
                "    }\n" +
                "    define collectable coin {\n" +
                "        start = 1,0;\n" +
                "        size = 1;\n" +
                "        direction = left;\n" +
                "    }\n" +
                "\n" +
                "BEHAVIOUR:\n" +
                "    define function move_left_right() {\n" +
                "        var count = 0;\n" +
                "        forever unless (var count > 100) {\n" +
                "            face right;\n" +
                "            move 1;\n" +
                "            wait 1 sec;\n" +
                "            face left;\n" +
                "            wait 1 sec;\n" +
                "            set count = (var count + 1);\n" +
                "        }\n" +
                "    }\n" +
                "    entity goomba {\n" +
                "        call move_left_right(var test, 1);\n" +
                "    }\n" +
                "    entity coin {\n" +
                "        wait 1 sec;\n" +
                "        call move_left_right();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var coin amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        TileMap game = builder.build();
        assertEquals(50, game.getCols());
        assertEquals(50, game.getRows());

        Player player = game.getPlayer();
        assertEquals(10, player.getHealth());
        assertEquals(2, player.getSize());
        assertEquals(0, player.getPosX());
        assertEquals(0, player.getPosY());

        List<Enemy> enemyList = game.getEnemies();
        assertEquals(1, enemyList.size());
        System.out.println(enemyList.get(0).getClass());
        System.out.println(enemyList.get(0).getX());
        System.out.println(enemyList.get(0).getY());
        System.out.println(enemyList.get(0).getDamage());
        System.out.println(enemyList.get(0).getDirection());

        Enemy goomba = enemyList.get(0);
        assertEquals(8, goomba.getHealth());
        assertEquals(Direction.UP.toString(), goomba.getDirection().toString());
        assertEquals(2, goomba.getDamage());

        List<Obstacle> obstacleList = game.getObstacles();
        assertEquals(1, obstacleList.size());
        Obstacle obstacle = obstacleList.get(0);
        assertEquals(2, obstacle.getX());
        assertEquals(2, obstacle.getY());

        List<Collectable> collectableList = game.getCollectables();
        assertEquals(1, collectableList.size());
        assertEquals(1, collectableList.get(0).getX());
        assertEquals(0, collectableList.get(0).getY());

    }

    @Test
    public void arenaTooLargeTest() {
        String input = "ARENA:\n" +
                "        size = 100;\n" +
                "ENTITIES: \n" +
                "        define player hero {\n" +
                "            start = 2,3;\n" +
                "            health = 100; \n" +
                "            size = 1; \n" +
                "            direction = up; \n" +
                "        }\n" +
                "        \n" +
                "BEHAVIOUR:\n" +
                "        entity hero { \n" +
                "            move 1; \n" +
                "            face left; \n" +
                "            wait 2 sec;\n" +
                "        } \n" +
                "        \n" +
                "END_CRITERIA: \n" +
                "        win: var hero amount equals 1;\n" +
                "        lose: var hero health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(ArenaTooLargeError.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });
    }


    @Test
    public void twoPlayersDefinedTest() {
        String input = "ARENA:\n" +
                "                size = 50;\n" +
                "                ENTITIES:\n" +
                "                        define player hero {\n" +
                "                            start = 2,3;\n" +
                "                            health = 100;\n" +
                "                            size = 1;\n" +
                "                            direction = up;\n" +
                "                        }\n" +
                "                        \n" +
                "                        define player sidekick {\n" +
                "                            start = 1,1;\n" +
                "                            health = 50;\n" +
                "                            size = 1;\n" +
                "                            direction = down;\n" +
                "                        }\n" +
                "\n" +
                "                BEHAVIOUR:\n" +
                "                        entity hero {\n" +
                "                           move 1;\n" +
                "                            face left;\n" +
                "                            wait 2 sec;\n" +
                "                        }\n" +
                "\n" +
                "                END_CRITERIA:\n" +
                "                        win: var hero amount equals 1;\n" +
                "                        lose: var hero health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(DuplicatePlayerDefinedError.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });
    }


    @Test
    public void multipleEnemiesTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 2,3;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define enemy joker {\n" +
                "                    start = 1,1;\n" +
                "                    health = 50;\n" +
                "                    size = 1;\n" +
                "                    direction = down;\n" +
                "                    damage = 2;\n" +
                "                }\n" +
                "\n" +
                "                define enemy twoface {\n" +
                "                    start = 2,2;\n" +
                "                    health = 55;\n" +
                "                    size = 1;\n" +
                "                    direction = right;\n" +
                "                    damage = 1;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "                entity batman {\n" +
                "                    move 1;\n" +
                "                    face left;\n" +
                "                    wait 2 sec;\n" +
                "                }\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var joker health equals 0;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        TileMap game = builder.build();
        assertEquals(50, game.getCols());
        assertEquals(50, game.getRows());

        Player player = game.getPlayer();
        assertEquals(100, player.getHealth());
        assertEquals(1, player.getSize());
        assertEquals(2, player.getPosX());
        assertEquals(3, player.getPosY());

        List<Enemy> enemyList = game.getEnemies();
        assertEquals(2, enemyList.size());

        Enemy joker = enemyList.get(0);
        assertEquals(1, joker.getX());
        assertEquals(1, joker.getY());
        assertEquals(50, joker.getHealth());
        assertEquals(Direction.DOWN.toString(), joker.getDirection().toString());
        assertEquals(2, joker.getDamage());

        Enemy twoface = enemyList.get(1);
        assertEquals(2, twoface.getX());
        assertEquals(2, twoface.getY());
        assertEquals(55, twoface.getHealth());
        assertEquals(Direction.RIGHT.toString(), twoface.getDirection().toString());
        assertEquals(1, twoface.getDamage());


        List<Obstacle> obstacleList = game.getObstacles();
        assertEquals(0, obstacleList.size());

        List<Collectable> collectableList = game.getCollectables();
        assertEquals(0, collectableList.size());

    }


    @Test
    public void multipleObstaclesTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 2,3;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define obstacle wall {\n" +
                "                    start = 1,1;\n" +
                "                    size = 2;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define obstacle DonyeWump {\n" +
                "                    start = 5,2;\n" +
                "                    size = 5;\n" +
                "                    direction = left;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        TileMap game = builder.build();
        assertEquals(50, game.getCols());
        assertEquals(50, game.getRows());

        Player player = game.getPlayer();
        assertEquals(100, player.getHealth());
        assertEquals(1, player.getSize());
        assertEquals(2, player.getPosX());
        assertEquals(3, player.getPosY());

        List<Enemy> enemyList = game.getEnemies();
        assertEquals(0, enemyList.size());

        List<Obstacle> obstacleList = game.getObstacles();
        assertEquals(2, obstacleList.size());

        Obstacle wall = obstacleList.get(0);
        assertEquals(1, wall.getX());
        assertEquals(1, wall.getY());

        Obstacle DonyeWump = obstacleList.get(1);
        assertEquals(5, DonyeWump.getX());
        assertEquals(2, DonyeWump.getY());

    }

    @Test
    public void multipleCollectablesTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 2,3;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define collectable NVDAStock {\n" +
                "                    start = 5,6;\n" +
                "                    size = 2;\n" +
                "                }\n" +
                "\n" +
                "                define collectable skibiddi {\n" +
                "                    start = 4,20;\n" +
                "                    size = 5;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();
        parsedProgram.accept(builder, evaluator);

        TileMap game = builder.build();
        assertEquals(50, game.getCols());
        assertEquals(50, game.getRows());

        Player player = game.getPlayer();
        assertEquals(100, player.getHealth());
        assertEquals(1, player.getSize());
        assertEquals(2, player.getPosX());
        assertEquals(3, player.getPosY());

        List<Enemy> enemyList = game.getEnemies();
        assertEquals(0, enemyList.size());

        List<Obstacle> obstacleList = game.getObstacles();
        assertEquals(0, obstacleList.size());

        List<Collectable> collectableList = game.getCollectables();
        assertEquals(2, collectableList.size());

        Collectable NVDAStock = collectableList.get(0);
        assertEquals(5, NVDAStock.getX());
        assertEquals(6, NVDAStock.getY());

        Collectable skibiddi = collectableList.get(1);
        assertEquals(4, skibiddi.getX());
        assertEquals(20, skibiddi.getY());

    }


    @Test
    public void playerOutOfBoundsTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 40,65;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(EntityStartOutOfBounds.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });
    }



    @Test
    public void enemyOutOfBoundsTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 4,20;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define enemy joker {\n" +
                "                    start = 20,60;\n" +
                "                    health = 3;\n" +
                "                    size = 2;\n" +
                "                    direction = right;\n" +
                "                    damage = 5;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(EntityStartOutOfBounds.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }


    @Test
    public void obstacleOutOfBoundsTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 4,20;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define obstacle wall {\n" +
                "                    start = 20,620;\n" +
                "                    size = 2;\n" +
                "                    direction = right;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(EntityStartOutOfBounds.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });
    }

    @Test
    public void collectableOutOfBoundsTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 4,20;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "                define collectable coin {\n" +
                "                    start = 2,90;\n" +
                "                    size = 2;\n" +
                "                    direction = right;\n" +
                "                }\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(EntityStartOutOfBounds.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }



    @Test
    public void entityInstructionEntityNotDefinedTest() {
        String input = "ARENA:\n" +
                "        size = 50;\n" +
                "        ENTITIES:\n" +
                "                define player batman {\n" +
                "                    start = 4,20;\n" +
                "                    health = 100;\n" +
                "                    size = 1;\n" +
                "                    direction = up;\n" +
                "                }\n" +
                "\n" +
                "\n" +
                "        BEHAVIOUR:\n" +
                "                entity spiderman {\n" +
                "                    wait 1 sec;\n" +
                "                    move 3;\n" +
                "                    wait 2 sec;\n" +
                "                }\n" +
                "\n" +
                "        END_CRITERIA:\n" +
                "                win: var batman amount equals 1;\n" +
                "                lose: var batman health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(InvalidEntityError.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }


    @Test
    public void varNotDefinedSetTestFunction() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    define function moo() {\n" +
                "        set fake = 10;\n" +
                "    }\n" +
                "    \n" +
                "    entity mario {\n" +
                "        call moo();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

        assertEquals("Referenced variable has not been initialized", e.getMessage());


    }


    @Test
    public void varNotDefinedSetTestEntity() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    entity mario {\n" +
                "        set fake = 10;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

        assertEquals("Referenced variable has not been initialized", e.getMessage());

    }

    @Test
    public void varDefinedAfterSetFunctionTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    entity mario {\n" +
                "        set fake = 10;\n" +
                "        var fake = 12;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

        assertEquals("Referenced variable has not been initialized", e.getMessage());

    }


    @Test
    public void divideByZeroTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    entity mario {\n" +
                "        move 3/0;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

        assertEquals("Move amount can't be computed: Cannot divide by 0", e.getMessage());
    }


    @Test
    public void undefinedFunctionCallTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    entity mario {\n" +
                "        call wiggle();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(Exception.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });
    }


    @Test
    public void functionCallBeforeDefinitionTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    entity mario {\n" +
                "        call wiggle();\n" +
                "    }\n" +
                "\n" +
                "    define function wiggle() {\n" +
                "        move 1;\n" +
                "        face left;\n" +
                "        move 1;\n" +
                "        face right;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(Exception.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }



    @Test
    public void undefinedVariableInUnlessTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    define function wiggle() {\n" +
                "        unless(var yes equals 1) {\n" +
                "            move 1;\n" +
                "            face left;\n" +
                "            move 1;\n" +
                "            face right;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    entity mario {\n" +
                "        call wiggle();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }



    @Test
    public void variableUsedBeforeDefinitionOutsideUnlessTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
                "\n" +
                "ENTITIES:\n" +
                "    define player mario {\n" +
                "        start = 0,0;\n" +
                "        health = 10;\n" +
                "        size = 2;\n" +
                "        direction = right;\n" +
                "     }\n" +
                "    define enemy goomba {\n" +
                "        health = 8;\n" +
                "        start = 0,5;\n" +
                "        size = 1;\n" +
                "        damage = 2;\n" +
                "        direction = up;\n" +
                "     }\n" +
                "\n" +
                "BEHAVIOUR:\n" +
                "    define function wiggle() {\n" +
                "        unless(var yes equals 1) {\n" +
                "            move 1;\n" +
                "            face left;\n" +
                "            move 1;\n" +
                "            face right;\n" +
                "        }\n" +
                "        var yes = 1;\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    entity goomba {\n" +
                "        call wiggle();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        Error e = assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });


    }


    @Test
    public void variableUsedBeforeDefinitionInsideUnlessTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
                "\n" +
                "ENTITIES:\n" +
                "    define player mario {\n" +
                "        start = 0,0;\n" +
                "        health = 10;\n" +
                "        size = 2;\n" +
                "        direction = right;\n" +
                "     }\n" +
                "    define enemy goomba {\n" +
                "        health = 8;\n" +
                "        start = 0,5;\n" +
                "        size = 1;\n" +
                "        damage = 2;\n" +
                "        direction = up;\n" +
                "     }\n" +
                "\n" +
                "BEHAVIOUR:\n" +
                "    define function wiggle() {\n" +
                "        unless(var yes equals 1) {\n" +
                "            move 1;\n" +
                "            face left;\n" +
                "            move 1;\n" +
                "            face right;\n" +
                "            var yes = 1;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    entity goomba {\n" +
                "        call wiggle();\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var mario amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";

        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertThrows(Error.class, () -> {
            parsedProgram.accept(builder, evaluator);
        });

    }

    @Test
    public void basicVarAndFuncTest() {
        String input = "ARENA:\n" +
                "    size = 50;\n" +
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
                "    define function move_left_right() {\n" +
                "        var x = 0;\n" +
                "        face right;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "        face left;\n" +
                "        set x = 9;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "        var e = 4;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var x amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertDoesNotThrow(() -> {
            parsedProgram.accept(builder, evaluator);
        });

    }


    @Test
    public void complexTest() {
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
                "    define enemy goomba {\n" +
                "        health = 8;\n" +
                "        start = 0,5;\n" +
                "        size = 1;\n" +
                "        damage = 2;\n" +
                "        direction = up;\n" +
                "     }\n" +
                "    define obstacle box {\n" +
                "        start = 2,2;\n" +
                "        size = 2;\n" +
                "        direction = down;\n" +
                "    }\n" +
                "    define collectable coin {\n" +
                "        start = 1,0;\n" +
                "        size = 1;\n" +
                "        direction = left;\n" +
                "    }\n" +
                "\n" +
                "BEHAVIOUR:\n" +
                "    define function move_left_right() {\n" +
                "        face right;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "        face left;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "    }\n" +
                "\n" +
                "    entity goomba {\n" +
                "        face right;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "        face left;\n" +
                "        move 5;\n" +
                "        wait 1 sec;\n" +
                "        var cookie = 0;\n" +
                "        forever unless (on pos 30, 5) {\n" +
                "            face right;\n" +
                "            move 5;\n" +
                "            unless (var cookie > 10) {\n" +
                "                face down;\n" +
                "                move var cookie;\n" +
                "                face up;\n" +
                "                move var cookie;\n" +
                "            }\n" +
                "            set cookie = var cookie + 1;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    entity coin {\n" +
                "        call move_left_right();\n" +
                "        move 15,15;\n" +
                "    }\n" +
                "\n" +
                "END_CRITERIA:\n" +
                "    win:\n" +
                "        var coin amount equals 10;\n" +
                "    lose:\n" +
                "        var mario health equals 0;\n";


        EZGameLexer lexer = new EZGameLexer(CharStreams.fromString(input));
        lexer.reset();
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        EZGameParser parser = new EZGameParser(tokens);
        ParseToASTVisitor visitor = new ParseToASTVisitor();
        Program parsedProgram = visitor.visitProgram(parser.program());

        EZGameBuilder builder = new EZGameBuilder();
        Evaluator evaluator = new Evaluator();

        assertDoesNotThrow(() -> {
            parsedProgram.accept(builder, evaluator);
        });

        TileMap game = builder.build();

        assertEquals(40, game.getCols());
        assertEquals(40, game.getRows());

        Player player = game.getPlayer();
        assertEquals(10, player.getHealth());
        assertEquals(2, player.getSize());
        assertEquals(0, player.getPosX());
        assertEquals(0, player.getPosY());

        List<Enemy> enemyList = game.getEnemies();
        assertEquals(1, enemyList.size());

        Enemy goomba = enemyList.get(0);
        assertEquals(8, goomba.getHealth());
        assertEquals(Direction.UP.toString(), goomba.getDirection().toString());
        assertEquals(2, goomba.getDamage());

        List<Obstacle> obstacleList = game.getObstacles();
        assertEquals(1, obstacleList.size());
        Obstacle obstacle = obstacleList.get(0);
        assertEquals(2, obstacle.getX());
        assertEquals(2, obstacle.getY());

        List<Collectable> collectableList = game.getCollectables();
        assertEquals(1, collectableList.size());
        assertEquals(1, collectableList.get(0).getX());
        assertEquals(0, collectableList.get(0).getY());




    }









}
