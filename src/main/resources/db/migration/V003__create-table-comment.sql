CREATE TABLE comment (
	id bigint not null auto_increment,
    service_order_id bigint not null,
    description text not null,
    send_date datetime not null,
    
    primary key (id)
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_service_order
FOREIGN KEY (service_order_id) REFERENCES service_order (id);
