@.str = internal constant [13 x i8] c"Hello, world\00"

; External declaration of the puts function
declare i32 @puts(i8* nocapture) nounwind

define i32 @test (i32 %a) {
  entry:
    %s1 = mul i32 %a, %a
    ret i32 %s1
}

define i32 @square_unsigned(i32 %a) {
  %1 = mul i32 %a, %a
  ret i32 %1
}

define i64 @fn_fib(i64 %.1) {
  fn_fib_entry:
    %cast210 = getelementptr [13 x i8],[13 x i8]* @.str, i64 0, i64 0
    call i32 @puts(i8* %cast210)

    %.3 = icmp sle i64 %.1, 1
    br i1 %.3, label %fn_fib_entry.if, label %fn_fib_entry.endif

  fn_fib_entry.if:
    ret i64 1

  fn_fib_entry.endif:
    %.6 = sub i64 %.1, 1
    %.7 = sub i64 %.1, 2
    %.8 = call i64 (i64) @"fn_fib"(i64 %.6)
    %.9 = call i64 (i64) @"fn_fib"(i64 %.7)
    %.10 = add i64 %.8, %.9
    ret i64 %.10
}
