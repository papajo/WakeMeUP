Faili, kuros esmu veicis izmaiņas
		App logo faili ( 4 mapēs, visos viens fails iekopēts, ģenerētie izdzēsti )
		fragment_main.xml( res/layout )
		string.xml( res/values )
		MainActivity.java ( src/com)



== == == == == == == == == == == == == == == == == == == ==
App skati

1. Sākums - visu modinātāju saraksts ( iespējas labot visādas lietas, dzēst modinātāju arī - uzpeldoša opcija "-" zīme, kurai uzspiežot parādās dzēst, pēc tā nospiešanas parādās jautājums, vai tiešām dzēst un jā/nē pogas, jā - dzēš, nē - iziet no paziņojuma atpakaļ uz skatu bez poppupa )

	- modinātāju saraksts
	- 	aktīvs/neaktīvs modinātājs - checkbox
	- augšā ir izvēlne
	- 	settings
	- 	pievienot jaunu
	- 	dzēst modinātāju ( popup view - are u sure son? yes/no pogas )

2. modinātāja pievienošanas/rediģēšanas skats
	+ laiks
	+ nosaukums (paskaidrojošais lauks un aktīvais lauks)
	+ atkārtot (paskaidrojošais lauks un aktīvais lauks)
		listview - dienas ar checkbox
	+ uzdevums (paskaidrojošais lauks un aktīvais lauks)
		listview - uzdevumu tipi ar radiopogu
	+ sarežģītība (paskaidrojošais lauks un aktīvais lauks)
		listview - sarežģītību tipi ar radiopogu
	+ skaņa (paskaidrojošais lauks un aktīvais lauks)
		hz kā šitas.... listview, kas rodas no javas izsaukuma?
	+ poga saglabāt
	+ poga atcelt
	- *ja pabeidzu agrāk, tad arī kādu nākamo programmu atvērt*


3. pamatuzstādījumu skats
	- aktīvs modinātājs darbībā - poga izslēgt/snooze
	- snooze pogas uzdevums ( noved pie modinātāja atlikšanas un iziešanas no appa )
	- izslēgt pogas uzdevums ( noved pie modinātāja izslēgšanas un iziešanas no appa )

	- modinātājs ir klusajā režīmā - checked/unchecked
	- modinātāja skaļums - popup, scrollbar, cancel/ok
	- snooze length - listview popup, cancel
	- sānu pogas darbība - listview popup, cancel