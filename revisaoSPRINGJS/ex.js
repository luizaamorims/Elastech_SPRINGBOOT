

// Fase 1: Fundamentos (Variáveis e Tipos de Dados)
let nome = "Luiza";
let idade = 22;
let estaAprovado = true;
const TAXA_FIXA = 0.15;

let anoAtual = 2025;
let anoNascimento = anoAtual - idade;
let messageBoasVindas = nome + " tem " + idade + " anos de idade.";

// Impressões pedidas na Fase 1
console.log("nome:", nome);
console.log("idade:", idade);
console.log("estaAprovado:", estaAprovado);
console.log("TAXA_FIXA:", TAXA_FIXA);
console.log("anoNascimento:", anoNascimento);
console.log("mensagemBoasVindas:", messageBoasVindas);
console.log("idade * TAXA_FIXA =", idade * TAXA_FIXA);

console.log("----------");

// Fase 2: Controle de Fluxo (Condicionais)
// 1. Condicional Simples (par/ímpar)
let numero = 7;
if (numero % 2 === 0) {
    console.log("O número", numero, "é par.");
} else {
    console.log("O número", numero, "é ímpar.");
}

// 2. Condicional Múltipla (classificação de pontuação)
let pontuacao = 85;
if (pontuacao >= 90) {
    console.log("Nota: A (Excelente)");
} else if (pontuacao >= 80) {
    console.log("Nota: B (Bom)");
} else if (pontuacao >= 70) {
    console.log("Nota: C (Regular)");
} else {
    console.log("Nota: D (Reprovado)");
}

// 3. Combinação de Lógica (temperatura e chuva)
let temperatura = 25;
let estaChovendo = false;
if (temperatura > 20 && estaChovendo === false) {
    console.log("Dia perfeito para sair!");
} else {
    console.log("Melhor ficar em casa ou levar um guarda-chuva.");
}

console.log("----------");

// Fase 3: Funções (Reutilização de Código)
// 1. Função Sem Parâmetros
function saudarUsuario() {
    console.log("Olá! Bem-vindo ao mundo das funções JavaScript.");
}
saudarUsuario();

// 2. Função Com Parâmetros
function calcularAreaRetangulo(largura, altura) {
    let area = largura * altura;
    console.log("Área do retângulo (" + largura + " x " + altura + ") =", area);
}
calcularAreaRetangulo(5, 10);
calcularAreaRetangulo(8, 4);

// 3. Função Com Retorno
function verificarMaioridade(idadeParam) {
    return idadeParam >= 18;
}
let maior = verificarMaioridade(22);
let menor = verificarMaioridade(15);
console.log("verificarMaioridade(22) ->", maior);
console.log("verificarMaioridade(15) ->", menor);