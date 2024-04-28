package com.tsimerekis.reverseengineerer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/api")
class MyKotlin {

  private final
  val logger: Logger = Logger.getLogger(LoggingInterceptor::class.java.name)

  @GetMapping("/hinge")
  fun hinge(): String {
    logger.info("We said hello!")
    return "Hello, Spring Boot in Kotlin!"
  }

}

