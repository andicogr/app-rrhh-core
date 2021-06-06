-- Table: public.company

-- DROP TABLE public.company;

CREATE TABLE public.company
(
    id integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    address character varying(200) COLLATE pg_catalog."default",
    brand_name character varying(200) COLLATE pg_catalog."default" NOT NULL,
    email character varying(64) COLLATE pg_catalog."default",
    phone character varying(15) COLLATE pg_catalog."default",
    ruc character varying(11) COLLATE pg_catalog."default" NOT NULL,
    status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT company_pkey PRIMARY KEY (id),
    CONSTRAINT uk_256oh3gqxkgglfeukwm3tw0rn UNIQUE (brand_name),
    CONSTRAINT uk_4wj9cgtgxme9ui0wlifm1ngeb UNIQUE (ruc)
)

TABLESPACE pg_default;

ALTER TABLE public.company OWNER to rrhh;

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id integer NOT NULL,
    created timestamp without time zone,
    created_by character varying(255) COLLATE pg_catalog."default",
    modified timestamp without time zone,
    modified_by character varying(255) COLLATE pg_catalog."default",
    password character varying(300) COLLATE pg_catalog."default" NOT NULL,
    status character varying(20) COLLATE pg_catalog."default" NOT NULL,
    username character varying(20) COLLATE pg_catalog."default" NOT NULL,
    company_id integer,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fkbwv4uspmyi7xqjwcrgxow361t FOREIGN KEY (company_id)
        REFERENCES public.company (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to rrhh;
