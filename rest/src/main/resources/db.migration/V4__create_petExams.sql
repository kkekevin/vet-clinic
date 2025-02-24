create table exames (
	cod_exame int primary key generated always as identity ,
	nome varchar(60) ,
	valor numeric(7,2)
);

create table exame_resultados (
	id int generated by default as identity ,
	resultado text ,
	cod_consulta int ,
	cod_exame int ,
		
	constraint pk_exame primary key (id) ,
	
	constraint fk_cod_consulta foreign key (cod_consulta) references consultas (cod_consulta) ,
	constraint fk_cod_exame foreign key (cod_exame) references exames (cod_exame)
);

create table invoice (
	id int primary key generated by default as identity ,
	consult_id int ,
	total numeric (7,2) ,
	
	constraint fk_consult_id foreign key (consult_id) references consultas (cod_consulta)
);

create sequence exame_resultados_seq start with 1 increment by 1;
create sequence invoice_seq start with 1 increment by 1;

-- SP trigger of invoice

create or replace function set_consultation_total ()
	returns trigger 
	language plpgsql
as 
$$
declare 
	total numeric (7,2);
begin
	select sum(exames.valor) into total from exame_resultados join exames on exames.cod_exame = 
		public.exame_resultados.cod_exame where public.exame_resultados.cod_consulta = new.consult_id;
	new.total := total;
	return new;
end;
$$;

drop trigger if exists set_consultation_total_trigger on public.consultas;

create trigger set_consultation_total_trigger
	before insert 
	on "invoice"
	for each row 
execute procedure set_consultation_total();