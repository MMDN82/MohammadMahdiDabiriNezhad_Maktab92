#!/bin/bash

PS3="Enter a number: "

select operation in addTask showuncomplete completeTask showComplete removeTask showRemoved search
 do
  case $operation in
  addTask)
    cat >>uncompleteTask.txt
    ;;
  showuncomplete)
    cat uncompleteTask.txt
    ;;
   completeTask)
    echo -n "Enter task: "
    read task
    echo "$task" >>completeTask.txt
    sed -i "/$task/d" uncompleteTask.txt
    ;;
   showComplete)
    cat completeTask.txt
    ;;
  removeTask)
 echo -n "Enter task: "
    read task

  if  grep -Fxq "$task" uncompleteTask.txt ; then
      sed -i "/$task/d" uncompleteTask.txt
      echo "$task" >>removed.txt
  fi
  if  grep -Fxq "$task" completeTask.txt ; then
      sed -i "/$task/d" completeTask.txt
      echo "$task" >>removed.txt
  fi
    ;;
  showRemoved)
    cat removed.txt
    ;;
  search)
     echo -n "Enter task: "
        read task
      if  grep -Fxq "$task" uncompleteTask.txt ; then
          echo uncompleteTask
      fi

      if  grep -Fxq "$task" completeTask.txt ; then
          echo completeTask
      fi

      if  grep -Fxq "$task" removed.txt ; then
          echo removed
      fi
    ;;


  *)
    esac
done

