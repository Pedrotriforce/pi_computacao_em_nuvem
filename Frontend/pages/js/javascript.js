// Dados dos serviços
const servicos = [
    { 
        nome: "Corte de Cabelo", 
        preco: 50,
        descricao: "Corte personalizado",
        iconeCustom: true,
        iconeUrl: '../assets/images/icone-corte.png'
    },
    { 
        nome: "Coloração", 
        preco: 120,
        descricao: "Técnicas modernas de coloração",
        iconeCustom : true,
        iconeUrl: '../assets/images/icone-coloracao.png'
    },
    { 
        nome: "Manicure", 
        preco: 30,
        descricao: "Cuidados completos para suas mãos",
        iconeCustom : true,
        iconeUrl: '../assets/images/icone-manicure.png'
    },
    { 
        nome: "Pedicure", 
        preco: 40,
        descricao: "Tratamento completo para seus pés",
        iconeCustom: true,
        iconeUrl: '../assets/images/icone-pedicure.png'
    },
    { 
        nome: "Maquiagem", 
        preco: 80,
        descricao: "Maquiagem profissional para qualquer ocasião",
        iconeCustom: true,
        iconeUrl: '../assets/images/icone-maquiagem2.png'
    }
];

// Preencher lista de serviços (Mantido intacto!)
if (window.location.pathname.includes('servicos.html')) {
    const listaServicos = document.getElementById('lista-servicos');
    
    servicos.forEach(servico => {
        listaServicos.innerHTML += `
            <div class="col-md-4">
                <div class="card card-servico h-100">
                    <div class="card-body text-center">
                        ${servico.iconeCustom 
                        ? `<img src="${servico.iconeUrl}" alt="${servico.nome}" class="custom-icon">` 
                        : `<i class="bi bi-${servico.icone} display-4 text-pink"></i>`}
                        <h5 class="card-title mt-3">${servico.nome}</h5>
                        <p class="card-text">${servico.descricao}</p>
                        <p class="fw-bold">R$ ${servico.preco.toFixed(2)}</p>
                        <a href="cadastro.html" class="btn btn-sm btn-primary">Agendar</a>
                    </div>
                </div>
            </div>
        `;
    });
}

// Gerenciar cadastro de clientes (Atualizado com a conexão Java!)
if (window.location.pathname.includes('cadastro.html')) {
    const formCadastro = document.getElementById('form-cadastro');
    
    formCadastro.addEventListener('submit', function(e) {
        e.preventDefault();
        
        // Pega os valores digitados no HTML
        const nome = document.getElementById('nome').value;
        const telefone = document.getElementById('telefone').value;
        
        // Monta o pacote de dados (O email não vai para o Java agora porque o banco não tem essa coluna)
        const dadosCliente = {
            nome: nome,
            telefone: telefone
        };

        // Feedback visual no botão enquanto processa
        const btnSubmit = formCadastro.querySelector("button[type='submit']");
        const textoOriginal = btnSubmit.innerHTML;
        btnSubmit.innerHTML = "Cadastrando no Servidor...";
        btnSubmit.disabled = true;

        // Bate na porta do servidor Java ao invés do localStorage
        fetch("http://localhost:8080/api/clientes", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dadosCliente)
        })
        .then(response => response.json())
        .then(data => {
            if(data.status === "sucesso") {
                alert("🎉 Uhuuul! Cadastro realizado com sucesso no banco de dados!");
                formCadastro.reset(); // Limpa os campos da tela
            } else {
                alert("❌ Ops: " + data.mensagem);
            }
        })
        .catch(error => {
            console.error("Erro na requisição:", error);
            alert("❌ Erro ao conectar com o servidor. O Java está rodando?");
        })
        .finally(() => {
            // Volta o botão ao normal
            btnSubmit.innerHTML = textoOriginal;
            btnSubmit.disabled = false;
        });
    });
}