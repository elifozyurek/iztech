#lang scheme
;question 5
(define square  ;procedure that calculates the square of a given number
  (lambda (a)
    (* a a))
 )

(define cube  ;procedure that calculates the cube of a given number
  (lambda (b)
    (* b b b))
)

;higher order procedure (takes procedures as parameters)
(define list_power
  (lambda (<operation> x_list) 
    (cond
      ((= (length x_list) 0) (append null null))  ;base case (same as Q3 and Q4)
      (else (append (list (<operation> (car x_list))) (list_power <operation> (cdr x_list))))
    )   ;the procedure we give as an argument is used here in place of <operation>
  )
)

;procedure for Q3 rewritten
(define (list_square a_list)
    (list_power square a_list))   ;calls the procedure above to calculate the square

;procedure for Q4 rewritten
(define (list_cube b_list)
    (list_power cube b_list))  ;calls the procedure above to calculate the cube

;function calls with different procedures/operations
(list_square (list 2 5 7))
(list_cube (list 2 5 7))
(list_power square (list 2 5 7))  ;or we can directly call the procedure that finds the powers
(list_power cube (list 2 5 7))

