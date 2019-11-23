package io.pivotal.librarydemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryDemoApplication

fun main(args: Array<String>) {
	runApplication<LibraryDemoApplication>(*args)
}
