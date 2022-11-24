#lang scheme
;question 3
(define square  ;procedure that calculates the square of a given number
  (lambda (a)
    (* a a))
)

(define list_square
  (lambda (a_list)
    (cond
      ((= (length a_list) 0) (append null null))  ;if the given list is empty we do not append anything (base case)
      (else (append (list (square (car a_list))) (list_square (cdr a_list))))
    )  ;procedure calls itself and adds the squared values to a new list until the given list is empty
  )
)

;procedure calls for arbitrary lists
(list_square (list ))
(list_square (list 4))
(list_square (list 2 5 7))
(list_square (list 6 8 1 3 4))
