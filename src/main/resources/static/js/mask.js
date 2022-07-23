// Mascaras para Inputs
var cpf = document.getElementById('cpf');
var celular = document.getElementById('celular');
var data = document.getElementById('data')

var cpfMaskOptions = {
	mask: '000.000.000-00'
};

var celularMaskOptions = {
	mask: '(00) 00000-0000'
};

var dataMaskOptions = {
	mask: '00/00/0000'
};

var cpfMask = IMask(cpf, cpfMaskOptions);
var celularMask = IMask(celular, celularMaskOptions);
var celularMask = IMask(data, dataMaskOptions);
