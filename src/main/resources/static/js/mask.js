var cpf = document.getElementById('cpf');
var celular = document.getElementById('celular');

var cpfMaskOptions = {
	mask: '000.000.000-00'
};

var celularMaskOptions = {
	mask: '(00) 00000-0000'
};

var cpfMask = IMask(cpf, cpfMaskOptions);
var celularMask = IMask(celular, celularMaskOptions);
