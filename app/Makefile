.PHONY: build

build:
	@./gradlew clean build

clean:
	@./gradlew clean

install:
	@./gradlew installDist

run-dist:
	@./build/install/app/bin/app

lint:
	@./gradlew checkstyleMain checkstyleTest

report:
	@./gradlew jacocoTestReport

test:
	@./gradlew test
