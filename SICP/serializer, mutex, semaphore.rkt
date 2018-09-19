#lang sicp
(define make-serializer
  (lambda(pro)
    (define (serialized-pro . args)
      (make-mutex 'acquire)
      (apply pro args)
      (make-mutex 'release)
    )
    serialized-pro
  )
)
(define make-mutex
  (let((cell (list false)))
    (define (mutex m)
      (cond ((eq? m 'acquire)
             (if (test cell)
                 (mutex 'acquire)
             )
            )
            ((eq? m 'release) (set-car! cell false))
      )
    )
    mutex
  )
)
(define (test cell)
  (if(car cell)
      true
     (begin (set-car! cell true)
      false
     )
  )
)
(define (make-semaphore n)

    (let ((mutex (make-mutex)))
        
        (define (acquire)
            (mutex 'acquire)
            (if (> n 0)                     ; 用互斥元保护 n 的修改
                (begin (set! n (- n 1))     ; 获取信号量之后
                       (mutex 'release)     ; 释放互斥元
                       'ok)
                (begin (mutex 'release)     ; 获取信号量不成功,先释放互斥元
                       (acquire))))         ; 然后再次尝试获取信号量

        (define (release)
            (mutex 'acquire)
            (set! n (+ n 1))              
            (mutex 'release)
            'ok)

        (define (dispatch mode)
            (cond ((eq? mode 'acquire)
                    (acquire))
                  ((eq? mode 'release)
                    (release))
                  (else
                    (error "Unknown mode MAKE-SEMAPHORE" mode))))

        dispatch))  
                                  
             
                       
                  
                               
                        
                       
     
