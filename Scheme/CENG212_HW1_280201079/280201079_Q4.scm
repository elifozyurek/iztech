#lang scheme
;question 4
(define cube  ;procedure that calculates the cube of a given number
  (lambda (b)
    (* b b b))
)

(define list_cube
  (lambda (b_list)
    (cond
      ((= (length b_list) 0) (append null null))  ;if the given list is empty we do not append anything (base case)
      (else (append (list (cube (car b_list))) (list_cube (cdr b_list))))
    )  ;procedure calls itself and adds the cubed values to a new list until the given list is empty
  )
)

;procedure calls for arbitrary lists
(list_cube (list ))
(list_cube (list 4))
(list_cube (list 2 5 7))
(list_cube (list 6 8 1 3 4))
