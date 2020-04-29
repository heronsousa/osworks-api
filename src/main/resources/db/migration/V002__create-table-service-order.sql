CREATE TABLE service_order (
	id bigint not null auto_increment,
    customer_id bigint not null,
    description text not null,
    price decimal(10,2) not null,
    status varchar(20) not null,
    opening_date datetime not null,
    closing_date datetime,
    
    primary key (id)
);

ALTER TABLE service_order ADD CONSTRAINT fk_service_order_customer
FOREIGN KEY (customer_id) REFERENCES customer (id)
