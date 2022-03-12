# TI-83 Compiler

A compiler/decompiler for TI-83 programs.

## Features

- Compile programs to .8xp files
- Uncompile .8xp files
- Optimize option to remove useless characters without changing program’s behavior
- Lock program editing from calculators

## Usage

### Compiling

*Source files’ extension must be one of the following: .ti83en, .ti83fr*

`java -jar TI-83_compiler-<version>.jar <file> -c [[-o] [-l]]`

- `<file>` (required) path to the file to compile
- `-c` (required) compile the file
- `-o` (optional) try to optimize the compiled program
- `-L` (optional) lock editing from calculators

### Decompiling

*Program files’ extension must be .8xp*

`java -jar TI-83_compiler-<version>.jar <file> -d -l=<lang> [-i=<indent>]`

- `<file>` (required) path to the file to compile
- `-d` (required) decompile the file
- `-l=<lang>` (required) language for the decompiled source file (`en` or `fr`)
- `-i=<indent>` (optional) indent size (number of spaces, default: 2)

### Help

`java -jar TI-83_compiler-<version>.jar -h`

Shows command usage and syntax.

`java -jar TI-83_compiler-<version>.jar -V`

Shows compiler’s version.

## Documentation

See the [wiki](https://github.com/Darmo117/TI-83_Compiler/wiki).
