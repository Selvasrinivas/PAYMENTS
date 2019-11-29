
INSERT INTO `144_bill_payment_system`.`user_role` (`ur_id`, `ur_ro_id`, `role_ro_id`) VALUES ('1', '1', '1');
INSERT INTO `144_bill_payment_system`.`user_role` (`ur_id`, `ur_ro_id`, `role_ro_id`) VALUES ('2', '2', '1');


INSERT INTO `144_bill_payment_system`.`user` (`user_id`, `first_name`, `last_name`, `age`, `gender`, `contact_number`, `pan`, `aadhar_number`, `usr_id`, `password`) VALUES ('2', 'Hari', 'Baskar', '25', 'male', '9874563214', '7425635874', '326585741256', 'usr2', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
INSERT INTO `144_bill_payment_system`.`user` (`user_id`, `first_name`, `last_name`, `age`, `gender`, `contact_number`, `pan`, `aadhar_number`, `usr_id`, `password`) VALUES ('3', 'Raj', 'Sharma', '36', 'male', '7485963214', '5874693214', '124578963265', 'usr3', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
INSERT INTO `144_bill_payment_system`.`user` (`user_id`, `first_name`, `last_name`, `age`, `gender`, `contact_number`, `pan`, `aadhar_number`, `usr_id`, `password`) VALUES ('4', 'Neha', 'Sharma', '45', 'female', '9696857474', '8574659585', '365214789654', 'usr4', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');
INSERT INTO `144_bill_payment_system`.`user` (`user_id`, `first_name`, `last_name`, `age`, `gender`, `contact_number`, `pan`, `aadhar_number`, `usr_id`, `password`) VALUES ('1', 'Sam', 'Anderson', '47', 'male', '7855889965', '7845123698', '125487955162', 'usr1', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');


INSERT INTO `144_bill_payment_system`.`role` (`ro_id`, `ro_name`) VALUES ('1', 'SUPER_ADMIN');
INSERT INTO `144_bill_payment_system`.`role` (`ro_id`, `ro_name`) VALUES ('2', 'ROLE_ADMIN');
INSERT INTO `144_bill_payment_system`.`role` (`ro_id`, `ro_name`) VALUES ('3', 'ROLE_USER');

INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('1', 'Electricity');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('2', 'Telephone');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('3', 'DTH');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('4', 'Insurance');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('5', 'Tax');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('6', 'Credit Card');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('7', 'Loan account');
INSERT INTO `144_bill_payment_system`.`bill_types` (`bill_type_id`, `bill_type_name`) VALUES ('8', 'Others');

INSERT INTO `144_bill_payment_system`.`bill` (`bill_id`, `bill_amount`, `bill_types_bill_type_id`, `user_user_id`) VALUES ('1', '300', '1', '1');
INSERT INTO `144_bill_payment_system`.`bill` (`bill_id`, `bill_amount`, `bill_types_bill_type_id`, `user_user_id`) VALUES ('2', '450', '2', '1');
INSERT INTO `144_bill_payment_system`.`bill` (`bill_id`, `bill_amount`, `bill_types_bill_type_id`, `user_user_id`) VALUES ('3', '758', '3', '2');