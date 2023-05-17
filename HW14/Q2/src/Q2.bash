#!/bin/bash
PS3="Enter a number: "
 select item in create write modify; do
  case $item in
  create)
    for i in {1..5} ; do
        touch $i.txt
    done
    ;;
  write)
    for i in {1..5} ; do
        echo "hello world" >>$i.txt
    done
    ;;
  modify)
    for i in *.txt ; do
     sed -i 's/world/bash/g' "$i"
    done
    ;;
  *)
    esac
done