/**
 * Inpedir espações em branco nos input[type='text']
 */
function validInputForm() {
	let btnForm = document.querySelector("input[type='submit']")
	let input = document.querySelector("input[type='text']")

	btnForm.addEventListener("click", () => {
		let str = input.value.trim()

		if (str.value == null || str.value == "") {
			console.log(str);
		}
		input.value = str;
	});
}

function myFunction() {
    var x = document.getElementById("sidebar-menu-options");

    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
}

/**
 * Mascaras para inputs
 */
function inputMask() {
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
}

validInputForm();
inputMask();
