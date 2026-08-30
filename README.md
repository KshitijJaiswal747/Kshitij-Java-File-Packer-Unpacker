# Kshitij-Java-File-Packer-Unpacker
Java based file packer and unpacker using file handling and byte streams.

A Java desktop utility that packs multiple files from a folder into a single archive file, and unpacks that archive back into the original files.

Features
- Pack all files in a chosen folder into a single archive file
- Unpack an archive back into the original files
- Pack multiple files into a single packed file
- Store file name and file size in a fixed 100-byte header
- Unpack files from the packed file
- Simple Java Swing GUI
- Uses FileInputStream and FileOutputStream
- Also runnable from the console (each class has its own main())

## Requirements

- JDK 17 or later
- Check Java installation using:
  ```bash
  java -version
  javac -version

## Build & run 
1.Compile: 
   javac -d . src\FilePacker\*.java
2.Run the GUI:
   java filepacker.main
The GUI provides options for packing and unpacking files.

## Known limitations
Subfolders inside the target folder are skipped, not recursively packed
File names that are too long may not fit inside the fixed 100-byte header
Packing and unpacking are performed on the main thread, so the GUI may appear unresponsive during large operations
The current archive format is intended for this application and does not provide compression or encryption

## Project Structure

```text
Java-Packer-Unpacker/
│
├── src/
│   └── filepacker/
│       ├── FilePackerFrame.java
│       ├── Packer.java
│       ├── Unpacker.java
│       └── main.java
│
├── .gitignore
├── LICENSE
└── README.md


