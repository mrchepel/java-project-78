.PHONY: build

lint:
	@make -C app lint

build:
	@make -C app build

install:
	@make -C app install

report:
	@make -C app report

test:
	@make -C app test