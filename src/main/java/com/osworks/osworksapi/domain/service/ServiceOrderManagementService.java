package com.osworks.osworksapi.domain.service;

import java.time.OffsetDateTime;

import com.osworks.osworksapi.domain.exception.EntityNotFoundException;
import com.osworks.osworksapi.domain.exception.ServiceException;
import com.osworks.osworksapi.domain.model.Comment;
import com.osworks.osworksapi.domain.model.Customer;
import com.osworks.osworksapi.domain.model.ServiceOrder;
import com.osworks.osworksapi.domain.model.ServiceOrderStatus;
import com.osworks.osworksapi.domain.repository.CommentRepository;
import com.osworks.osworksapi.domain.repository.CustomerRepository;
import com.osworks.osworksapi.domain.repository.ServiceOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderManagementService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ServiceOrder create(ServiceOrder serviceOrder) {
        Customer customer = customerRepository.findById(serviceOrder.getCustomer().getId())
                            .orElseThrow(() -> new ServiceException("Cliente não encontrado."));

        serviceOrder.setCustomer(customer);
        serviceOrder.setStatus(ServiceOrderStatus.ABERTA);
        serviceOrder.setOpeningDate(OffsetDateTime.now());

        return serviceOrderRepository.save(serviceOrder);
    }

    public Comment addComment(Long serviceOrderId, String description) {

        ServiceOrder serviceOrder = serviceOrderRepository.findById(serviceOrderId)
                            .orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

        Comment comment = new Comment();
        comment.setDescription(description);
        comment.setSendDate(OffsetDateTime.now());
        comment.setServiceOrder(serviceOrder);

        return commentRepository.save(comment);
    }
}