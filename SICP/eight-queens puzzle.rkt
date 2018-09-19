#lang sicp
(define (list-int low high)
  (if (> low high)
      nil
      (cons low (list-int (+ 1 low) high))
   )
)
(define (newmap trans item)
  (if (null? item)
      nil
      (cons (trans (car item)) (newmap trans (cdr item))
      )
   )
)
(define (accumulate op initial sequence)
  (if (null? sequence)
      initial
      (op (car sequence) (accumulate op initial (cdr sequence)))
   )
)
(define (filter predicate sequence)
  (cond ((null? sequence) nil)
        ((predicate (car sequence))
         (cons (car sequence) (filter predicate (cdr sequence))))
        (else (filter predicate (cdr sequence)))
   )
)  
(define (flatmap proc sequence)
  (accumulate append nil (newmap proc sequence))
)
(define (queens number-of-rows)
  (define (queen-cols k)
    (if (= k 0)
        (list nil)
        (filter (lambda (positions)
                  (safe? k positions)
                ) (flatmap (lambda(rest)
                             (newmap (lambda(new-row)
                                    (cons new-row rest)            ;add new queens
                                  ) (list-int 1 number-of-rows)
                              )
                            ) (queen-cols (- k 1))
                    )
          )
     )
  )
 (queen-cols number-of-rows)
)
(define (safe? k position)
    (iter-check (car position) 
                (cdr position)
                 1))

(define (iter-check row-of-new-queen rest-of-queens i)
    (if (null? rest-of-queens)  ; 下方所有皇后检查完毕,新皇后安全
        #t
        (let ((row-of-current-queen (car rest-of-queens)))
            (if (or (= row-of-new-queen row-of-current-queen)           ; 行碰撞
                    (= row-of-new-queen (+ i row-of-current-queen))     ; 右下方碰撞
                    (= row-of-new-queen (- row-of-current-queen i)))    ; 左下方碰撞
                #f
                (iter-check row-of-new-queen (cdr rest-of-queens)    ; 继续检查剩余的皇后
                            (+ i 1))))))            ; 更新步进值




