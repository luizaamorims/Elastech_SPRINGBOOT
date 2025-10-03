create table produto(
                         id int not null primary key auto_increment,
                         nome varchar(100) not null,
                         descricao varchar(200),
                         preco numeric(18,2)
);

insert into produto (nome, descricao, preco) values
    ('Livro A', 'Romance de aventura e mistério', 39.90);

insert into produto (nome, descricao, preco) values
    ('Livro B', 'Guia prático de programação Java', 79.50);

insert into produto (nome, descricao, preco) values
    ('Livro C', 'Coleção de receitas culinárias', 49.99);
