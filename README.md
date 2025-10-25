# EzGame Domain Specific Language (DSL)

## Introduction

Welcome to EZGame, a DSL designed for creating simple 2D games without requiring advanced programming or game design knowledge. We provide the freedom to customize your game however you wish—from creating maps and defining win/loss conditions to designing player and enemy behavior. You can even leverage functions, loops, and mutable variables to bring your unique vision to life.



## Inspiration
We created EZGame to serve as a **stepping stone for new coders**—a creative experience that builds upon the foundations of block-based languages like **Scratch** but offers greater complexity and control. Our goal was to design a language that avoids overwhelming users with the strict syntax and extensive libraries often found in professional game development environments and programming languages. With EZGame, you can express your creativity and build your own 2D game with just a few lines of code, offering a direct and rewarding path into game design.

## The basics

Any functional program using our DSL adheres to the following format:

```
ARENA:
    [contents]
ENTITIES:
    [contents]
BEHAVIOUR:
    [contents]
END_CRITERIA:
    [contents]
```

As you may have gathered by now, the contents within each section define
that aspect of the game. We start with Arena, since it is by far the simplest.

The only statement that can be placed within this section is of the form
```size = INTEGER;```, where ```INTEGER <= 25```. This establishes the arena as a 
size-by-size 2D grid of tiles, each of which have x and y coordinates such that
```0 <= x, y < size```.

```
ARENA:
    size = 25;
ENTITIES:
    [contents]
BEHAVIOUR:
    [contents]
END_CRITERIA:
    [contents]
```

The semicolon at the end of the size statement is very important and must appear after every statement you will write
(except for entity/function/behavior definitions and loops, which we'll get into later), as it informs the DSL on where 
a statement ends and the next begins. For the sake of your program's readability, do not ignore the indentation of 
this statement either.

## Entities

This section is reponsible for defining the attributes (NOT behaviors) of every entity that will appear in your game.

There are four classes of entities: player, enemy, obstacle, and collectable. Every entity definition must include three
attributes; the entity's **start** coordinates (e.g. 5,4 ), its **size** (entities are represented as squares in the 
arena), and the **direction** it faces (up, left, down, or right).

Player and enemy definitions must also include an integer **health** attribute, and enemies must include an integer
**damage** attribute. An entity definition must follow this format:

```
define [entity_type] [entity_name] {
    [attribute_name] = [attribute_value];
    (2-4 more of these)
}
```

These curly brackets signify that every statement within them belongs to the enclosing entity definition.

Defining multiple entities is no problem! But it is very important that **every defined entity has a distinct name**.

For example,

```
ARENA:
    size = 25;
ENTITIES:
    define player mario {
        start = 0,0;
        health = 10;
        size = 2;
        direction = right;
    }
    define enemy goomba {
        health = 8;
        start = 0,5;
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
    [contents]
END_CRITERIA:
    [contents]
```

## Behaviours

Now, it's time to define each non-player entity's behaviors. This is the most open-ended section by far, and allows you 
to get as creative as you wish. But of course, there are guidelines your program must follow.

Naturally, you can directly assign behavior instructions to entities. These must follow the following format:

```
entity [case-sensitive entity_name] {
    [instruction];
    (more instructions)
}
```

### Simple

The basic instructions you can assign are as follows:

```face [direction];``` faces the entity in the specified direction, which can be up/down/left/right.

```var [name] = [value];```defines a mutable variable with the specified value and unique name. This
value (more generally, anything denoted by **[value]** in this section) can either be an integer or a mathematical 
expression (explained later).

```set [name] = [value];```sets the value of a previously-defined mutable variable using the specified value.

```move ([value] | [coordinate pair]);```moves the entity. If a value is provided, the entity moves in the driection
it currently faces. Otherwise, it moves towards the specified coordinates (e.g. move 10,10;).

```wait [value] sec;``` makes the entity wait a few seconds before executing the next instruction.

**[value]** can be an integer, a pre-defined variable (referenced by ```var [name]```), or a mathematical expression 
of the format ```[value1] [operator] [value2]```. If either value1 or value2 are expressions themselves, they must be
surrounded by parentheses. 

For instance, declaring ```set var = 3 + 4 * 5;``` would not be valid, but declaring ```set var = 3 + (4 * 5);``` would.
Alternatively, if we declared another variable "foo" to equal 4, we could instead declare ```set var = 3 + (var foo * 5);```.

### Advanced (some programming knowledge recommended)

#### Functions

If you wish to get more adventurous, you can also define functions within the Behaviours section. A function definition
follows the following format:

```
define function [function_name]([arg1_name], ...) {
    [instructions];
}
```

Each function must have a unique name, and can be called by any entity's behaviour clause. Functions can optionally require 
numerical arguments as input, which can be referenced within the function definition just like mutable variables (see above). 

The instruction to call a function is ```call [function_name]([arg1_value], ...);```. Just like the **[value]**'s from earlier,
an argument value can be an integer, a pre-defined variable, or a mathematical expression.

For example, a function definition and calls may look like

```
define function move_left_right() {
    face right;
    move 5;
    wait 1 sec;
    face left;
    move 5;
    wait 1 sec;
}

entity example1 {
    call move_left_right();
    move 15,15;
}

entity example2 {
    wait (4*2) sec;
    call move_left_right();
}
```

#### "Forever" Loops/Unless statements

Within the body of a function definition or an entity's behavior section, you can include a loop to repeatedly execute 
instructions until a certain condition is met, or you can add an Unless statement to only execute the instructions within
if that condition is not met. A "forever" loop must have the following format:

```
forever unless ([condition]) {
    [instructions];
}
```

Similarly, an unless statement looks like

```
unless ([condition]) {
    [instructions];
}
```

**[condition]**'s can take four main forms and can only evaluate to true or false: 

comparison: ```[value1] [comparison operator] [value2]```.

Value1 and Value2 are **[value]**'s (as defined above). The comparison operator can be <, >, equals (NOT =), <=, or >=.

"on" clause: ```on pos x,y```. 

This returns true if the entity 
executing this loop/statement is on the specified position.

conjunction: ```[condition1] [and/or] [condition2]```

negation: ```not [condition1]```

In either of these cases, condition1 and condition2 must be surrounded by parentheses, as they are **[condition]**'s themselves.

**Please note that any variables declared within a function definition, loop, or unless statement cannot be referenced 
outside of their respective scopes.**

## End criteria

Finally, we establish the criteria for the game to be won or lost. 
Here you can specify the conditions for the end of the game by defining a condition.
An end condition must follow this format:

```
[win|lose]:
    var *entity_name* [amount|health] *comparison*;
```

You can specify both a win condition and a lose condition.
For an end condition, you first specify the entity. Then, you either specify if the condition is for health or amount (score).
As well, specify the condition.

An example is seen below:

```
END_CRITERIA:
    win:
        var coin amount equals 10;
    lose:
        var mario health equals 0;
```

## Resolution

Putting everything together, here is an example of a complete program:

```
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
        start = 0,5;
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
        face right;
        move 5;
        wait 1 sec;
        face left;
        move 5;
        wait 1 sec;
    }

    entity goomba {
        face right;
        move 5;
        wait 1 sec;
        face left;
        move 5;
        wait 1 sec;
        var cookie = 0;
        forever unless (on pos 30, 5) {
            face right;
            move 5;
            unless (var cookie > 10) {
                face down;
                move var cookie;
                face up;
                move var cookie;
            }
            set cookie = var cookie + 1;
        }
    }

    entity coin {
        call move_left_right();
        move 15,15;
    }

END_CRITERIA:
    win:
        var coin amount equals 10;
    lose:
        var mario health equals 0;
```



## Get started

To run the app, generate the antlr parser/lexer files in the src/parser folder (this step is already done here).
Then, write your program in the input.ezgame file. 
Finally, run src/ui/Main.java file and your coded game will appear in a new window.


### Developers
- Alexander Jacobson, Mattias Sebanc, Melanie Kent, Rehnoor Saini, William Cheng


### Resources
* **EZGame Language Structure & Interpretation (CPSC 410, UBC):**
    * Some aspects of `Environment.java` and `Evaluator.java` was inspired by the class example **"tinyVars"**.
    * Some aspects of `ParseToASTVisitor.java` and `src/ui/Main.java` was inspired by the class example **"tinyHTML"**.
* Animal Pack sprites by Kenney.nl: https://kenney.nl/assets/animal-pack
* Simplified Platformer Pack sprites by Kenney.nl: https://kenney.nl/assets/simplified-platformer-pack


