// 📡 Configuração da API
const API_BASE = 'http://localhost:8081/autores';

// 🎯 Elementos do DOM
const formularios = {
    buscar: document.getElementById('formBuscar'),
    adicionar: document.getElementById('formAdicionar'),
    atualizar: document.getElementById('formAtualizar'),
    deletar: document.getElementById('formDeletar')
};

// 🏠 Funções de Navegação
function voltarMenu() {
    Object.values(formularios).forEach(form => {
        form.classList.remove('ativo');
    });
    limparTodosResultados();
}

function mostrarBuscar() {
    voltarMenu();
    formularios.buscar.classList.add('ativo');
}

function mostrarAdicionar() {
    voltarMenu();
    formularios.adicionar.classList.add('ativo');
}

function mostrarAtualizar() {
    voltarMenu();
    formularios.atualizar.classList.add('ativo');
}

function mostrarDeletar() {
    voltarMenu();
    formularios.deletar.classList.add('ativo');
}

// 🧹 Funções de Limpeza
function limparTodosResultados() {
    document.getElementById('resultadoBusca').innerHTML = '';
    document.getElementById('resultadoAdicionar').innerHTML = '';
    document.getElementById('resultadoAtualizar').innerHTML = '';
    document.getElementById('resultadoDeletar').innerHTML = '';
}

function limparFormAdicionar() {
    document.getElementById('nomeAutor').value = '';
    document.getElementById('dataNasc').value = '';
    document.getElementById('resultadoAdicionar').innerHTML = '';
}

function limparFormAtualizar() {
    document.getElementById('idAtualizar').value = '';
    document.getElementById('nomeAtualizar').value = '';
    document.getElementById('dataNascAtualizar').value = '';
    document.getElementById('resultadoAtualizar').innerHTML = '';
}

function limparFormDeletar() {
    document.getElementById('idDeletar').value = '';
    document.getElementById('resultadoDeletar').innerHTML = '';
}

// 🛠️ Funções Utilitárias
function mostrarMensagem(elemento, mensagem, tipo) {
    elemento.innerHTML = `
        <div class="mensagem ${tipo}">
            ${mensagem}
        </div>
    `;
}

function mostrarLoading(elemento) {
    elemento.innerHTML = `
        <div class="loading">
            ⏳ Processando...
        </div>
    `;
}

// 🔍 BUSCAR AUTOR POR ID
async function buscarAutor() {
    const id = document.getElementById('idBusca').value;
    const resultadoDiv = document.getElementById('resultadoBusca');

    if (!id) {
        mostrarMensagem(resultadoDiv, '❌ Por favor, digite um ID válido.', 'erro');
        return;
    }

    mostrarLoading(resultadoDiv);

    try {
        const resposta = await fetch(`${API_BASE}/${id}`);

        if (!resposta.ok) {
            throw new Error('Autor não encontrado');
        }

        const autor = await resposta.json();

        resultadoDiv.innerHTML = `
            <div class="resultado">
                <h3>✅ Autor Encontrado</h3>
                <div class="dados-autor">
                    <div class="campo-dado"><strong>ID:</strong> ${autor.id}</div>
                    <div class="campo-dado"><strong>Nome:</strong> ${autor.nome}</div>
                    <div class="campo-dado"><strong>Data de Nascimento:</strong> ${formatarData(autor.dataNasc)}</div>
                </div>
            </div>
        `;

    } catch (erro) {
        mostrarMensagem(resultadoDiv, `❌ Erro: ${erro.message}`, 'erro');
    }
}

// ➕ ADICIONAR NOVO AUTOR
async function adicionarAutor() {
    const nome = document.getElementById('nomeAutor').value;
    const dataNasc = document.getElementById('dataNasc').value;
    const resultadoDiv = document.getElementById('resultadoAdicionar');

    if (!nome || !dataNasc) {
        mostrarMensagem(resultadoDiv, '❌ Por favor, preencha todos os campos.', 'erro');
        return;
    }

    mostrarLoading(resultadoDiv);

    try {
        const autorDTO = {
            nome: nome,
            dataNasc: dataNasc
        };

        const resposta = await fetch(`${API_BASE}/addAutor`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(autorDTO)
        });

        if (!resposta.ok) {
            throw new Error('Erro ao cadastrar autor');
        }

        const autorSalvo = await resposta.json();

        mostrarMensagem(resultadoDiv,
            `✅ Autor "${autorSalvo.nome}" cadastrado com sucesso! ID: ${autorSalvo.id}`,
            'sucesso'
        );

        // Limpa o formulário após sucesso
        setTimeout(() => {
            limparFormAdicionar();
        }, 3000);

    } catch (erro) {
        mostrarMensagem(resultadoDiv, `❌ Erro ao cadastrar autor: ${erro.message}`, 'erro');
    }
}

// 🔍 BUSCAR DADOS ATUAIS PARA ATUALIZAÇÃO
async function buscarParaAtualizar() {
    const id = document.getElementById('idAtualizar').value;
    const resultadoDiv = document.getElementById('resultadoAtualizar');

    if (!id) {
        mostrarMensagem(resultadoDiv, '❌ Por favor, digite um ID válido.', 'erro');
        return;
    }

    mostrarLoading(resultadoDiv);

    try {
        const resposta = await fetch(`${API_BASE}/${id}`);

        if (!resposta.ok) {
            throw new Error('Autor não encontrado');
        }

        const autor = await resposta.json();

        // Preenche os campos com os dados atuais
        document.getElementById('nomeAtualizar').value = autor.nome;
        document.getElementById('dataNascAtualizar').value = autor.dataNasc;

        mostrarMensagem(resultadoDiv,
            `✅ Dados do autor carregados. Agora faça as alterações necessárias.`,
            'sucesso'
        );

    } catch (erro) {
        mostrarMensagem(resultadoDiv, `❌ Erro: ${erro.message}`, 'erro');
    }
}

// ✏️ ATUALIZAR AUTOR
async function atualizarAutor() {
    const id = document.getElementById('idAtualizar').value;
    const nome = document.getElementById('nomeAtualizar').value;
    const dataNasc = document.getElementById('dataNascAtualizar').value;
    const resultadoDiv = document.getElementById('resultadoAtualizar');

    if (!id || !nome || !dataNasc) {
        mostrarMensagem(resultadoDiv, '❌ Por favor, preencha todos os campos.', 'erro');
        return;
    }

    mostrarLoading(resultadoDiv);

    try {
        const autorAtualizado = {
            id: parseInt(id),
            nome: nome,
            dataNasc: dataNasc
        };

        const resposta = await fetch(`${API_BASE}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(autorAtualizado)
        });

        if (!resposta.ok) {
            throw new Error('Erro ao atualizar autor');
        }

        mostrarMensagem(resultadoDiv,
            `✅ Autor "${nome}" atualizado com sucesso!`,
            'sucesso'
        );

        // Limpa o formulário após sucesso
        setTimeout(() => {
            limparFormAtualizar();
        }, 3000);

    } catch (erro) {
        mostrarMensagem(resultadoDiv, `❌ Erro ao atualizar autor: ${erro.message}`, 'erro');
    }
}

// 🗑️ DELETAR AUTOR
async function deletarAutor() {
    const id = document.getElementById('idDeletar').value;
    const resultadoDiv = document.getElementById('resultadoDeletar');

    if (!id) {
        mostrarMensagem(resultadoDiv, '❌ Por favor, digite um ID válido.', 'erro');
        return;
    }

    if (!confirm(`⚠️ Tem certeza que deseja deletar o autor com ID ${id}? Esta ação não pode ser desfeita.`)) {
        return;
    }

    mostrarLoading(resultadoDiv);

    try {
        const resposta = await fetch(`${API_BASE}/${id}`, {
            method: 'DELETE'
        });

        if (!resposta.ok) {
            throw new Error('Erro ao deletar autor');
        }

        mostrarMensagem(resultadoDiv,
            `✅ Autor com ID ${id} deletado com sucesso!`,
            'sucesso'
        );

        // Limpa o formulário após sucesso
        setTimeout(() => {
            limparFormDeletar();
        }, 3000);

    } catch (erro) {
        mostrarMensagem(resultadoDiv, `❌ Erro ao deletar autor: ${erro.message}`, 'erro');
    }
}

// 📅 Função para formatar data
function formatarData(dataString) {
    if (!dataString) return 'Não informada';

    const data = new Date(dataString);
    return data.toLocaleDateString('pt-BR');
}

// 🎉 Inicialização
document.addEventListener('DOMContentLoaded', function() {
    console.log('🚀 Sistema de Autores inicializado!');
    console.log('📡 API Base:', API_BASE);

    // Verifica se a API está respondendo
    fetch(`${API_BASE}/mensagem`)
        .then(response => response.json())
        .then(data => {
            console.log('✅ API conectada:', data.mensagem);
        })
        .catch(erro => {
            console.warn('⚠️ Não foi possível conectar com a API. Verifique se o Spring Boot está rodando.');
        });
});