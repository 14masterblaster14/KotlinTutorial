import java.io.File
import java.io.PrintWriter
import java.nio.charset.Charset

fun main(args: Array<String>) {

    // File Operations:

    // Create File

    var fileName = "sample.txt"
    var file_object = File(fileName)
    var file_exist = file_object.exists()
    println(file_exist)                     // false
    val isNewFileCreated = file_object.createNewFile()
    println(isNewFileCreated)                     // true
    file_exist = file_object.exists()
    println(file_exist)                     // true

    // Write File
    var file_text = "This is Sample File."
    file_object.writeText(file_text)

    var fileName1 = "D:\\Android\\Projects\\Kotlin_Tuts\\data.txt"
    var file_objects = File(fileName1)
    var file_text1 = "This is sample data file.Now, we can play with this file as you want.\n\t Please close the file after your work is done."
    file_objects.writeText(file_text1)


    ///  Read File

    /*
    File.bufferedReader() : To read contents of a file into BufferedReader
    File.forEachLine() : To read a file line by line in Kotlin
    File.inputStream() : To read contents of file to InputStream
    File.readBytes() : To read contents of file to ByteArray
    File.readLines() : To read lines in file to List
    File.readText() : To read contents of file to a single String       */

    //    File.bufferedReader() : To read contents of a file into BufferedReader

    val bufferedReader = file_object.bufferedReader()
    val texts = bufferedReader.readLine()
    for (line in texts) {
        println(line)
    }
    /*O/P:-
            T
            h
            i
            s

            i
            s

            S
            a
            m
            p
            l
            e

            F
            i
            l
            e
            .
    */

    // File.forEachLine() : To read a file line by line in Kotlin

    file_object.forEachLine { println(it) }     // This is Sample File.

    //File.inputStream() : To read contents of file to InputStream

    var inputString = file_object.inputStream()
    var content = inputString.readBytes().toString(Charset.defaultCharset())
    println(content)            // This is Sample File.

    //File.readBytes() : To read contents of file to ByteArray

    var bytes: ByteArray = file_object.readBytes()
    for (byte in bytes) {
        print(byte.toChar())
    }                           // This is Sample File.

    //File.readLines() : To read lines in file to List
    var lines = file_object.readLines()
    for (line in lines) {
        println(line)
    }

    //File.readText() : To read contents of file to a single String
    var contents = file_object.readText()
    println(contents)


    ///  Write content to the File
    /*
    java.io.PrintWriter
    java.io.File.printWriter()
    java.io.File.bufferedWriter()
    java.io.File.writeText()
    */

    //printWriter() function
    val file_Name1 = "Testing1.txt"
    var file_content1 = "This is test1 file."
    val writer = PrintWriter(file_Name1)
    writer.append(file_content1)
    writer.close()

    //Or
    val file_contents = "This is awesome!"
    File("Testings.txt").printWriter().use { out -> out.println(file_contents) }

    // Internallly calling constructor
    val file_Name2 = "Testing2.txt"
    var file_content2 = "This is test2 file."
    File(file_Name2).printWriter().use { param -> param.println(file_content2) }

    //java.io.File.bufferedWriter()
    val file_Name3 = "Testing3.txt"
    var file_content3 = "This is test3 file."
    File(file_Name3).bufferedWriter().use { out -> out.write(file_content3) }

    //writeText() function
    val file_Name = "Testing.txt"
    var file_content = "This is test file."
    File(file_Name).writeText(file_content)


    ///  Append content to the File

    File(file_Name).appendText("This is appended text.")

    /// Copy a file into another
    val newFileName = "CopyFile.txt"
    //File(file_Name).copyTo(File(newFileName))
    File(file_Name).copyTo(File(newFileName), true)     // will override if file already exists, wont give error
    //File(file_Name).copyTo(File(newFileName),false)     // wont override if file already exists, will give error


    // Traversing through all files in directory
    //  walk(), walkBottomUp, walkTopDown()

    File("D:\\Android\\Projects\\Kotlin_Tuts\\").walkBottomUp().forEach { println(it) }
    println("---------------------------")
    File("D:\\Android\\Projects\\Kotlin_Tuts\\").walkTopDown().forEach { println(it) }

    // Delete Recursively
    var fileA = File("folderA")
    fileA.deleteRecursively()   // All files and folders in folderA will be deleted
}


