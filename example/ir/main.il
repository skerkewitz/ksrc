define i32 @fib () {
  entry: 
    %comp1 = icmp eq i32 0, %n
    br i1 %comp1, label %is_zero, label %is_not_zero

  is_zero: 
    ret i32 %n

  is_not_zero: 
    %comp2 = icmp eq i32 1, %n
    br i1 %comp2, label %is_one, label %is_not_one

  is_one: 
    ret i32 %n

  is_not_one: 
    %first = sub i32 %n, 1
    %first_result = call i32 @fib()
    %second = sub i32 %n, 2
    %second_result = call i32 @fib()
    %result = add i32 %first_result, %seconds_result
    ret i32 %result

}