package io.pivotal.librarydemo.controller

import io.pivotal.librarydemo.dao.LibraryDao
import io.pivotal.librarydemo.model.Book
import io.pivotal.librarydemo.model.Library
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import java.util.function.Function

@ExtendWith(SpringExtension::class)
@WebFluxTest(LibraryController::class)
class LibraryControllerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockBean
    lateinit var libraryDao: LibraryDao

    @Test
    fun getLibraryTest() {
        val expected: Library = Library("Test Library", listOf(Book("book1", "author", listOf("tdd"))))

        Mockito.`when`(libraryDao.getLibrary()).thenReturn(Mono.just(expected))

        webTestClient.get()
                .uri("/library")
                .exchange()
                .expectStatus().isOk
                .expectBody(Library::class.java)
    }
}