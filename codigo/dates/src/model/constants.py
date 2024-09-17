from __init__ import datetime, pytz

# Github
ORG_NAME = 'cc-icc'
# Assignment prefix
ASSIGNMENT_PREFIX = 'practica-4-programacion-estructurada'
# Start date
timezone = pytz.timezone("UTC")
START_DATE_NATIVE = datetime.strptime('2024-09-03', "%Y-%m-%d")
START_DATE = timezone.localize(START_DATE_NATIVE)   
# Output file
OUTPUT_DIR = 'output'
OUTPUT_FILE = 'icc_p4.xlsx'
LOGGER = True  # Cambiar a False para deshabilitar la impresión
# llave = nombre del estudiante, valor = usuario de github
GITHUIB_USERS = {
"aguilarvillegasalejandrosaid" : "AlejandroAguilar2002",
"aguirreconsuegrasergiodaniel" : "DanielUnam09",
"barrerareyesgael" : None,
"becerravalenciacesar" : "BecVal",
"cisnerosalvarezdanjiro" : "DanjiroCis",
"cortesnavajoseluis" : "luuisjnc",
"diazaguilaromar" : "Tao0Tao00",
"diazanaviajavieromar" : "JavierDx139",
"espejelbaezjuanarturo" : "ThrinkEsBa",
"espinogutierrezalejandro" : "alejandro-espino-gut",
"garciaislasfernando" : "eltrex58",
"gironcruzdaniel" : "DanielGironCruz",
"hernandezislasleonardodaniel" : "LeoDan17-01",
"juarezfloresluisalberto" : "Luis7211",
"juarezreyesjoseadan" : "Josesitore391",
"martinezsasagurikiyomiamanda" : "kiyomar",
"menesesmercadoerikeduardo" : "erik-meneses",
"montijodiazomar" : "omaarr28",
"nunezhernandezleonardodaniel" : "leodan-hdez",
"ochoacamposanasofia" : "soffochoa",
"ojedatruebasergioluis" : None,
"olmosortizandrealucia" : "andylmr",
"ortizgarciakevinjahir" : None,
"padillacastanedajosecarlos" : None,
"ramirezmendozajoaquinrodrigo" : "Joaquin58",
"realaraizayamile" : "YamileRea",
"reyesnunezerikarenata" : "Erika801",
"reynosoascencioalexa" : "alexareynoso",
"rodriguezcentenoemiliano" : None,
"rodriguezlopezluisfernando" : "LU1ZRL",
"rodriguezzosayasevelin" : None,
"rosalessanchezleonardobenjamin" : "NanoCorpSA",
"salinastrinidadbetsiivana" : "BetsiTrinidad",
"sanchezgarciahugo" : "hugosczs",
"sanchezloaezadanaximena" : "Danaloaeza",
"tenorioreyesihebelluro" : "IhebelTenorio",
"trevinopueblahectorjerome" : "hectorjerome",
"valadezperezrodrigo" : "ValadezRP",
"vazquezmerinomerinoleninquetzal" : "leninlo",
"villalobosjuarezgontraneliut" : "GontranV"
}

SPECIAL_USERS = ['LeoDan17-01', 'DanielUnam09']