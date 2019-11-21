const functions = require('firebase-functions');

const json = [
	{
		"model": "Boeing-737",
		"company": "MAU",
		"speed": "800",
		"route": "Lviv-London",
		"poster": "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg"
	},
	{
		"model": "Boeing-737",
		"company": "Turkish Airlines",
		"speed": "700",
		"route": "Toronto-Texas",
		"poster": "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX182_CR0,0,182,268_AL_.jpg"
	},
	{
		"model": "Boeing-767",
		"company": "Turkish Airlines",
		"speed": "750",
		"route": "Leverkusen-Kyiv",
		"poster": "https://m.media-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_UX182_CR0,0,182,268_AL_.jpg"
	},
	{
		"model": "Boeing-767",
		"company": "Lufthansa",
		"speed": "850",
		"route": "Praha-Rome",
		"poster": "https://m.media-amazon.com/images/M/MV5BYzg5YmUyNGMtMThiNS00MjA2LTgwZDctNDlhM2RkZDNmZmRkXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_UX182_CR0,0,182,268_AL_.jpg"
	}
];

exports.planes = functions.https.onRequest((request, response) => { 
	response.send(json);
});

