	.file	"prog.c"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movl	$12, -8(%rbp)
	movl	-8(%rbp), %eax
	leal	-5(%rax), %edx
	movl	-8(%rbp), %eax
	movl	%edx, %esi
	movl	%eax, %edi
	call	simpleEx
	movl	%eax, -4(%rbp)
	movl	-8(%rbp), %eax
	movl	%eax, %esi
	movl	$14, %edi
	call	simpleEx
	addl	%eax, -4(%rbp)
	movl	$0, %eax
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.globl	simpleEx
	.type	simpleEx, @function
simpleEx:
.LFB1:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	%edi, -20(%rbp)
	movl	%esi, -24(%rbp)
	movl	$7, -4(%rbp)
	movl	-24(%rbp), %eax
	leal	(%rax,%rax), %edx
	movl	-20(%rbp), %eax
	addl	%edx, %eax
	subl	-4(%rbp), %eax
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1:
	.size	simpleEx, .-simpleEx
	.ident	"GCC: (Ubuntu 4.8.4-2ubuntu1~14.04.3) 4.8.4"
	.section	.note.GNU-stack,"",@progbits
