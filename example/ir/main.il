define int32 @fib () {
  entry:
    %0 = icmp eq i32 0, %n
    br i1 %0, label %is_zero, label %is_not_zero

  is_zero:
    ret int32 %n

  is_not_zero:
    %0 = icmp eq i32 1, %n
    br i1 %0, label %is_one, label %is_not_one

  is_one:
    ret int32 %n

  is_not_one:
    %first = icmp eq i32 %n, 1
    %first_result = call int32fib ()
    %second = icmp eq i32 %n, 2
    %second_result = call int32fib ()
    %result = icmp eq i32 %first_result, %seconds_result
    ret int32 %result

}