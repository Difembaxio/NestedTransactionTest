package com.example.TransactionalDemoProject.service;

import com.example.TransactionalDemoProject.model.A;
import com.example.TransactionalDemoProject.repository.ARepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceA {

    private final ARepository repA;
    private final ServiceB serviceB;


    /* В этом методе будет 1 транзакция и вызвана она будет из сервиса Б в сервисе б метода пропагейшен
     Requir а тут метод не тразакционный
     */
    public void methodPropRequiredNoTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropRequiredNoTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropRequired();
        log.info("Вызов метода methodPropRequiredNoTransaction сервиса А закончен");
    }

    /*  В этом методе будет 1 транзакция и вызвана она будет из сервиса А
     тразакция из сервиса B вызвана не будет так как сервисе б у метода пропагейшен
     Required  все пройдет в рамках одной транзакции
    */
    @Transactional
    public void methodPropRequiredTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropRequiredTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropRequired();
        log.info("Вызов метода methodPropRequiredTransaction сервиса А закончен");
    }

    /*  В этом методе будет 1 транзакция и вызвана она будет из сервиса А
     тразакция из сервиса B вызвана не будет так как сервисе б у метода пропагейшен
     Supports все пройдет в рамках одной транзакции так  как этот параметр указывает что спринг
     его нужно выполнять только тогда когда она уже существует
    */
    @Transactional
    public void methodPropSupports() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropSupports сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropSupports();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }


     /*  В этом методе не будет не одной транзакции methodPropSupportsNoTransaction не транзакционный,
    а у метод methodPropSupports из сервиса б Supports так как этот параметр указывает что спринг
     его нужно выполнять только  когда транзакция уже  существует
    */
    public void methodPropSupportsNoTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropSupportsNoTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropSupports();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*  Этот метод отработает без проблем, будет тразакция одна из сервиса A так как
     пропагейшен Mandatory выполняется при наличии уже существующей транзакции
     */
    @Transactional()
    public void methodPropMandatory() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropMandatory сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropMandatory();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*  Этот метод выбросит исключение IllegalTransactionStateException так как пропагейшен Mandatory
        выполняется при наличии уже существующей транзакции тут её нет
      */
    public void methodPropMandatoryNotTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropMandatoryNotTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropMandatory();
        log.info("Вызов метода methodPropMandatoryNotTransaction сервиса А закончен");
    }

    /*  Этот метод выбросит исключение IllegalTransactionStateException так как пропагейшен NEVER
        говорит что метод не выполнится если транзакция существует
     */
    @Transactional()
    public void methodPropNever() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNever сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNever();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*  Этот наоборот все отрабатывает нормально, но транзакции не будет */
    public void methodPropNeverNotTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNeverNotTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNever();
        log.info("Вызов метода methodPropNeverNotTransaction сервиса А закончен");
    }

    /*  Этот метод выполнится, но тразакции не будет   так как пропагейшен Not_Supported
        говорит что  существующая транзакция будет приостановлена и метод выполнится без транзакции.
     */
    @Transactional()
    public void methodPropNot_Supported() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNot_Supported сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNot_Supported();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*
    Также отрабатывает, но транзакции нет
    */
    public void methodPropNot_SupportedNotTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNot_SupportedNotTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNot_Supported();
        log.info("Вызов метода methodPropNot_SupportedNotTransaction сервиса А закончен");
    }


    /*
    Эта транзакция приостанавливается так как параметр пропагейшен Requires_New
     в методе сервиса B создается новая транзакция в итоге отрабатывает метод из сервиса B
     */
    @Transactional()
    public void methodPropRequires_New() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropRequires_New сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropRequires_New();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*
    Метод отрабатывает, но тразакция создается только в методе сервиса B
     */
    public void methodPropRequires_NewNotTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropRequires_NewNotTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropRequires_New();
        log.info("Вызов метода methodPropRequires_NewNotTransaction сервиса А закончен");
    }
    /*
        Этот метод выбрасывает исключение, JpaDialect не поддерживает точки сохранения
        - проверьте возможности вашего JPA-провайдера, но я понял пропагейшен Nested
          приостанавливает текущую транзакцию и создает в ней точку сохранения,
           в которую база данных вернётся, даже если вызываемый метод сгенерирует исключение.
     */
    @Transactional()
    public void methodPropNested() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNested сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNested();
        log.info("Вызов метода methodPropSupports сервиса А закончен");
    }

    /*
    Тут так как метод не транзакционный отрабатывает метод из сервиса Б и все транзакция одна
  */
    public void methodPropNestedNotTransaction() {
        A a = repA.findById(1L).orElseThrow(()-> new RuntimeException("А не найдено"));
        a.setNumber(a.getNumber()+1);
        log.info("Вызван метод methodPropNestedNotTransaction сервиса А. а.number = " + a.getNumber());
        serviceB.methodPropNested();
        log.info("Вызов метода methodPropNestedNotTransaction сервиса А закончен");
    }
}
