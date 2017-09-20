# TI-83_Compiler
A compiler/decompiler for TI-83 programs.

## Features
- Compile programs to .8xp files
- Optimise option to remove useless instructions without changing program's behavior
- Uncompile .8xp files

## Usage
*Source files' extension must be one of the following: .ti83, .ti83en, .ti83fr*

To compile, run `java -jar TI-83_compiler.jar <path_to_file> [-O]` where `<path_to_file>` is the path to the source file.
To enable optimisation, add `-O` option at the end of the command.

To uncompile a program file, run `java -jar TI-83_compiler.jar <path_to_file> -u <language>` where `<path_to_file>` is the
path to the source file and `<language>` is the desired instructions' language (either `en` for English or `fr` for French).

## Documentation
Will come soon!
