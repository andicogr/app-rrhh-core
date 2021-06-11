INSERT INTO public.company(
	id, created, created_by, modified, modified_by, address, brand_name, email, phone, ruc, status)
	VALUES (1, now(), 'admin', null, null, 'Mz T, Lt 14 Presidencia de la Republica',
			'Andres Gonzales S.A.C', 'agonzalesr93@gmail.com', '+51 956 291 034', '10476240307', 'ACTIVE');

INSERT INTO public.company(
	id, created, created_by, modified, modified_by, address, brand_name, email, phone, ruc, status)
	VALUES (2, now(), 'admin', null, null, 'Mz T, Lt 14 Presidencia de la Republica',
			'Jeico Manuel S.A.C', 'agonzalesr93@gmail.com', '+51 956 291 034', '1014255807', 'ACTIVE');

INSERT INTO public.users(
	id, created, created_by, modified, modified_by, password, status, username)
	VALUES (1, now(), 'admin', null, null, 'admin', 'ACTIVE', 'admin');

INSERT INTO public.user_company(
	user_id, company_id)
	VALUES (1, 1);

INSERT INTO sunat_table_3(id, code, sunat_code, description, status, company_id, created_by, created) VALUES
(nextval('hibernate_sequence'),'DNI','01','DOC. NACIONAL DE IDENTIDAD', 'ACTIVE', 1, 'admin', now()),
(nextval('hibernate_sequence'),'CE','04','CARNÉ DE EXTRANJERÍA', 'ACTIVE', 1, 'admin', now()),
(nextval('hibernate_sequence'),'RUC','06','REG. ÚNICO DE CONTRIBUYENTES (*)', 'ACTIVE', 1, 'admin', now()),
(nextval('hibernate_sequence'),'PAS','07','PASAPORTE', 'ACTIVE', 1, 'admin', now()),
(nextval('hibernate_sequence'),'PN','11','PARTIDA DE NACIMIENTO', 'ACTIVE', 1, 'admin', now());
