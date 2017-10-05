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

`java -jar <compiler_name>.jar -f <path> [-O|-L]`

- `-f <path>` tells that the file to compile is found at `<path>`
- `-O` if present, the compiler will try to optimise the program
- `-L` if present, the compiled program will be locked (i.e. it will be impossible to edit from the calculator)

### Decompiling
*Program files' extension must be .8xp*

`java -jar <compiler_name>.jar -f <path> -u <lang> -i <indent>`

- `-f <path>` tells that the file to decompile is found at `<path>`
- `-u <lang>` indicates the language for the decompiled source file (`en` or `fr`)
- `-i <indent>` specifies the indent size (number of spaces)

### Help
`java -jar TI-83_compiler.jar -h`

This option will show command usage and syntax.


## Documentation
See the [wiki](https://github.com/Darmo117/TI-83_Compiler/wiki).
