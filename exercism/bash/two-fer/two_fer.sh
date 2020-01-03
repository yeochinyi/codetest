#!/usr/bin/env bash

# Simple greeting app
main () {
    echo "One for ${1:-you}, one for me."
}
main "$@"
