	.globl	_main
_main:
	pushq	%rbp
	movq	%rsp, %rbp
	leaq	L_.string_const_0(%rip), %rsi
	leaq	L_.string_wformat(%rip), %rdi
	callq	_printf
	popq	%rbp
	retq

L_.s_nop:
	.asciz	""

L_.int_wformat:
	.asciz	"%d\12"

L_.float_wformat:
	.asciz	"%f\12"

L_.char_wformat:
	.asciz	"%c\12"

L_.string_wformat:
	.asciz	"%s\12"

L_.int_rformat:
	.asciz	"%d"

L_.float_rformat:
	.asciz	"%f"

L_.char_rformat:
	.asciz	"%c"

L_.string_rformat:
	.asciz	"%s"

L_.string_const_0:
	.asciz	"Hello world!"

