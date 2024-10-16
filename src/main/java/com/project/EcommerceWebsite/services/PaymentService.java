package com.project.EcommerceWebsite.services;

import com.project.EcommerceWebsite.models.Cart;
import com.project.EcommerceWebsite.models.Payment;
import com.project.EcommerceWebsite.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository repository;

    public Payment create(Integer id, List<Cart> cartitems) {
        Payment payment = new Payment();
        payment.setUserid(id);
        Date dateNow = new Date();
        payment.setDatepaid(dateNow);
        Float totalPrice=0.0F;
        if (cartitems != null) {
            for (Cart cart : cartitems) {
                totalPrice += cart.getPrice();
            }
        }
        payment.setTotal(totalPrice);
        repository.save(payment);
        return payment;
    }

    public Optional<Payment> read(int id) {
        return repository.findById(id);
    }

    public List<Payment> readAllUserid(int id) {
        return repository.findAllByUserid(id);
    }

    public List<Payment> readAll() {
        return repository.findAll();
    }

    public String update(Payment payment) {
        if(repository.existsById(payment.getId())) {
            Optional<Payment> value = repository.findById(payment.getId());
            if(value.isPresent()) {
                Payment existingPayment = value.get();
                existingPayment.setUserid(payment.getUserid());
                existingPayment.setDatepaid(payment.getDatepaid());
                existingPayment.setTotal(payment.getTotal());
                repository.save(existingPayment);
                return "Updated";
            }
            else
                return "Payment not found";
        }
        else
            return "Payment not found";
    }

    public String delete(int id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted";
        }
        else
            return "Payment not found";
    }
}
