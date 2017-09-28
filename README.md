# TI-83 Compiler
A compiler/decompiler for TI-83 programs.

## Features
- Compile programs to .8xp files
- Uncompile .8xp files
- Optimise option to remove useless characters without changing program's behavior
- Lock program editing from calculators

## Usage
### Compiling
*Source files' extension must be one of the following: .ti83, .ti83en, .ti83fr*

`java -jar TI-83_compiler.jar -f <file> [-O|-L]`

+ `-f <file>` path to the source file
+ `-O` enable program optimisation: useless characters will be removed to speed up program execution
+ `-L` disables program editing from a calculator

### Decompiling
*Program files' extension must be .8xp*

`java -jar TI-83_compiler.jar -f <file> -u <lang>`

+ `-f <file>` path to the program file
+ `-u <lang>` target language (`en`, `fr`) for decompiled sources

### Help
`java -jar TI-83_compiler.jar -h`

This option will show command usage and syntax.


## Documentation
See the [wiki](https://github.com/Darmo117/TI-83_Compiler/wiki).
