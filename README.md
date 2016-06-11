[![CircleCI](https://circleci.com/gh/be-hase/output-capture.svg?style=svg)](https://circleci.com/gh/be-hase/output-capture)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.be-hase.output-capture/output-capture/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.be-hase.output-capture/output-capture)

# output-capture

[Java] Output capture for testing.
Inspired by OutputCapture of Spring Boot.

## How to use ?

```java
@Rule
public OutputCapture capture = new OutputCapture();

@Test
public void useToString() throws Exception {
	System.out.println("Hello World!");
	assertThat(capture.toString(), containsString("World"));
}

@Test
public void useExpect() throws Exception {
	System.out.println("Hello World!");
	capture.expect(containsString("World"));
}

```