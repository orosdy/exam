--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-06-16 15:33:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16394)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    isbn bigint NOT NULL,
    author character varying(255),
    price integer NOT NULL,
    publisher character varying(255),
    subtitle character varying(255),
    title character varying(255)
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16426)
-- Name: book_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16402)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customerid bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    registration timestamp without time zone,
    regular boolean NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16428)
-- Name: customer_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_seq OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16410)
-- Name: genre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genre (
    genreid bigint NOT NULL,
    form character varying(255),
    genre character varying(255),
    series character varying(255),
    subgenre character varying(255)
);


ALTER TABLE public.genre OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16430)
-- Name: genre_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genre_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genre_seq OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16418)
-- Name: store; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.store (
    storeid bigint NOT NULL,
    city character varying(255),
    clerk character varying(255),
    house_number integer NOT NULL,
    manager character varying(255),
    store_name character varying(255),
    street character varying(255),
    zip integer NOT NULL
);


ALTER TABLE public.store OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16432)
-- Name: store_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.store_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.store_seq OWNER TO postgres;

--
-- TOC entry 2843 (class 0 OID 16394)
-- Dependencies: 202
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book (isbn, author, price, publisher, subtitle, title) VALUES (1, 'teszt', 2400, 'proba', 'kiserlet', 'teszt cim');
INSERT INTO public.book (isbn, author, price, publisher, subtitle, title) VALUES (52, 'teszt', 2500, 'publisher', 'subtitle', 'title');
INSERT INTO public.book (isbn, author, price, publisher, subtitle, title) VALUES (53, 'Author Arthur', 3000, 'Big Publisher', 'Great Subtitle', 'Telling Title');
INSERT INTO public.book (isbn, author, price, publisher, subtitle, title) VALUES (54, 'Author Arthur', 3500, 'Big Publisher', 'Best Subtitle', 'The Title');


--
-- TOC entry 2844 (class 0 OID 16402)
-- Dependencies: 203
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customer (customerid, first_name, last_name, registration, regular) VALUES (1, 'Lajos', 'Proba', '2020-06-14 16:38:37.183', true);
INSERT INTO public.customer (customerid, first_name, last_name, registration, regular) VALUES (2, 'Elemer', 'Teszt', '2020-06-14 16:38:37.183', true);
INSERT INTO public.customer (customerid, first_name, last_name, registration, regular) VALUES (3, 'Lajos', 'Szabo', NULL, false);


--
-- TOC entry 2845 (class 0 OID 16410)
-- Dependencies: 204
-- Data for Name: genre; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.genre (genreid, form, genre, series, subgenre) VALUES (1, 'prose', 'science-fiction', 'Star Trek', 'space');
INSERT INTO public.genre (genreid, form, genre, series, subgenre) VALUES (2, 'prose', 'science-fiction', 'Star Wars', 'space');
INSERT INTO public.genre (genreid, form, genre, series, subgenre) VALUES (3, 'prose', 'fantasy', 'Harry Potter', '');
INSERT INTO public.genre (genreid, form, genre, series, subgenre) VALUES (4, 'drama', 'comedy', '', 'satire');
INSERT INTO public.genre (genreid, form, genre, series, subgenre) VALUES (5, 'poetry', 'love', '', '');


--
-- TOC entry 2846 (class 0 OID 16418)
-- Dependencies: 205
-- Data for Name: store; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.store (storeid, city, clerk, house_number, manager, store_name, street, zip) VALUES (1, 'City', 'Clerk Clark', 1, 'Manager Manfred', 'Store Name', 'Street Street', 1234);
INSERT INTO public.store (storeid, city, clerk, house_number, manager, store_name, street, zip) VALUES (2, 'City', 'Assistant Arnold', 2, 'Manager Marcel', 'Other Name', 'Other Street', 2345);
INSERT INTO public.store (storeid, city, clerk, house_number, manager, store_name, street, zip) VALUES (3, 'Town', 'Bob', 3, 'Joe Smith', '', 'Road road', 3456);


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 206
-- Name: book_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_seq', 151, true);


--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 207
-- Name: customer_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_seq', 101, true);


--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 208
-- Name: genre_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genre_seq', 101, true);


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 209
-- Name: store_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.store_seq', 101, true);


--
-- TOC entry 2710 (class 2606 OID 16401)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (isbn);


--
-- TOC entry 2712 (class 2606 OID 16409)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customerid);


--
-- TOC entry 2714 (class 2606 OID 16417)
-- Name: genre genre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genre
    ADD CONSTRAINT genre_pkey PRIMARY KEY (genreid);


--
-- TOC entry 2716 (class 2606 OID 16425)
-- Name: store store_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.store
    ADD CONSTRAINT store_pkey PRIMARY KEY (storeid);


-- Completed on 2020-06-16 15:33:48

--
-- PostgreSQL database dump complete
--

