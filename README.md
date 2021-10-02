### rdstation-lead-api

#### POST: http://localhost:8080/api/rd-station

"json": {
	"eventType":"CONVERSION",
	"eventFamily":"CDP",	
	"payload":{				        
		"conversionIdentifier":"Identificador",
		"name":"Luiz A R da Silva",                
		"email":"luiz.trisoft@gmail.com",               
		"personalPhone":"(31)555-9999",       
		"cfZohoSegmento":"Zoho Segmento",      
		"cfZohoPerfilMudanca":"Perfil mudança", 
		"cfZohoProduto":"Produdo (Livro Java 16)",       
		"cfCnpj":"84.945.750/0001-26",              
		"trafficValue":"Valor de Tráfego",        
		"trafficSource":"Código de tráfego",       
		"cfUtmSource":"Código UTM",         
		"cfUtmMedium":"Media UTM",         
		"cfUtmCampaign":"Campanha UTM"
	}
}
