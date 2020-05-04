package com.osworks.osworksapi.api.controller;

import javax.validation.Valid;

import com.osworks.osworksapi.api.model.CommentModel;
import com.osworks.osworksapi.domain.model.Comment;
import com.osworks.osworksapi.domain.service.ServiceOrderManagementService;
import com.osworks.osworksapi.api.model.CommentInput;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/service-order/{serviceOrderId}/comments")
public class CommentController {

    @Autowired
    private ServiceOrderManagementService serviceOrderManagement;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentModel create(@PathVariable Long serviceOrderId, @Valid @RequestBody CommentInput commentInput) {
        Comment comment = serviceOrderManagement.addComment(serviceOrderId, commentInput.getDescription());
        
        return toModel(comment);
    }

    private CommentModel toModel(Comment comment) {
        return modelMapper.map(comment, CommentModel.class);
    }
}