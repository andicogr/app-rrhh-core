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