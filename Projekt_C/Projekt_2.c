// Projekt vypracoval Filip Pauco ; IDE - Dev-c++

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Osoba
{
	char prez[52];
	char rc[12];
	char kpm[5];
	char nazov[152];
	char mena[202];
	char typ[4];
	char cas[6];
	char datum[10];
	struct Osoba *dalsi;
};

void v(struct Osoba *prvy, FILE *subor){
	int i = 1;
	if(subor != NULL){	
		while(prvy != NULL){
			printf("%d.\n",i);
			printf("Prezenter: %s\n",(*prvy).prez);
			printf("rodne cislo: %s\n",(*prvy).rc);
			printf("kod prezentacnej miestnosti: %s\n",(*prvy).kpm);
			printf("nazov prispevku: %s\n",(*prvy).nazov);
			printf("mena autorov: %s\n",(*prvy).mena);
			printf("typ prezentovania: %s\n",(*prvy).typ);
			printf("cas prezentovania: %s\n",(*prvy).cas);
			printf("datum: %s\n",(*prvy).datum);
			printf("\n");
			i++;
			prvy = (*prvy).dalsi;
		}
	}
}


void n(struct Osoba **prvy,struct Osoba **druhy,struct Osoba **treti,struct Osoba **stvrty,struct Osoba **piaty,struct Osoba **siesty,FILE *subor){
	char cc[255];
	int i;
	int pocet = 0;
	if(subor != NULL){
		if(*prvy == NULL && *druhy == NULL && *treti == NULL && *stvrty == NULL && *piaty == NULL && *siesty == NULL){
		
	*prvy = (struct Osoba*)malloc(sizeof(struct Osoba));
	*druhy = (struct Osoba*)malloc(sizeof(struct Osoba));		
	*treti = (struct Osoba*)malloc(sizeof(struct Osoba));
	*stvrty = (struct Osoba*)malloc(sizeof(struct Osoba));
	*piaty = (struct Osoba*)malloc(sizeof(struct Osoba));
	*siesty = (struct Osoba*)malloc(sizeof(struct Osoba));
	
	/* skusal som aj cyklus (vo viacerych ulohach), tam kde mi nepracoval tak som to robil bez cyklu 
	fgets(cc,255,subor); //preskoci prvy riadok
	for(i = 0;i < pocet;i++){
		fgets(cc,255,subor);
		strcpy((**prvy).prez,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).rc,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).mena,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).typ,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).cas,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		*prvy = (**prvy).dalsi;
		
	}
	*/
		
		
		fgets(cc,255,subor); //preskoci prvy riadok
		fgets(cc,255,subor);
		strcpy((**prvy).prez,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).rc,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).mena,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).typ,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).cas,cc);
		fgets(cc,255,subor);
		strcpy((**prvy).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**prvy).dalsi = *druhy;
		
		
		fgets(cc,255,subor);
		strcpy((**druhy).prez,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).rc,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).mena,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).typ,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).cas,cc);
		fgets(cc,255,subor);
		strcpy((**druhy).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**druhy).dalsi = *treti;
		
		fgets(cc,255,subor);
		strcpy((**treti).prez,cc);
		fgets(cc,255,subor);
		strcpy((**treti).rc,cc);
		fgets(cc,255,subor);
		strcpy((**treti).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**treti).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**treti).mena,cc);
		fgets(cc,255,subor);
		strcpy((**treti).typ,cc);
		fgets(cc,255,subor);
		strcpy((**treti).cas,cc);
		fgets(cc,255,subor);
		strcpy((**treti).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**treti).dalsi = *stvrty;
		
		fgets(cc,255,subor);
		strcpy((**stvrty).prez,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).rc,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).mena,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).typ,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).cas,cc);
		fgets(cc,255,subor);
		strcpy((**stvrty).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**stvrty).dalsi = *piaty;
		
		fgets(cc,255,subor);
		strcpy((**piaty).prez,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).rc,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).mena,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).typ,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).cas,cc);
		fgets(cc,255,subor);
		strcpy((**piaty).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**piaty).dalsi = *siesty;
		
		fgets(cc,255,subor);
		strcpy((**siesty).prez,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).rc,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).kpm,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).nazov,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).mena,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).typ,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).cas,cc);
		fgets(cc,255,subor);
		strcpy((**siesty).datum,cc);
		fgets(cc,255,subor);    // preskoci posledny riadok
		pocet++;
		(**siesty).dalsi = NULL;
		
		rewind(subor);
		
		printf("Nacitalo sa <%d> zaznamov.\n",pocet);		
		}
		
		else{
			struct Osoba *akt;			
			akt = *prvy;
				while(*prvy != NULL){
				akt = *prvy;
				*prvy = (**prvy).dalsi;
				free(akt);
				}
				
			
		}
			
	}
	else
		printf("Zaznamy neboli nacitane!\n");
}

void h(struct Osoba *prvy){
	int i = 1;
	char c[5];
	int pocet = 0;
		if(prvy == NULL){
		return;
	}
	printf("Zadaj Kod prezentacnej miestnosti \n");
	scanf("%s",&c);
	while (prvy != NULL){
		(*prvy).kpm[strlen((*prvy).kpm)-1] = '\0';
		if (strcmp((*prvy).kpm,c) == 0){
			printf("%d.\n",i);
			printf("Prezenter: %s\n",(*prvy).prez);
			printf("rodne cislo: %s\n",(*prvy).rc);
			printf("kod prezentacnej miestnosti: %s\n",(*prvy).kpm);
			printf("nazov prispevku: %s\n",(*prvy).nazov);
			printf("mena autorov: %s\n",(*prvy).mena);
			printf("typ prezentovania: %s\n",(*prvy).typ);
			printf("cas prezentovania: %s\n",(*prvy).cas);
			printf("datum: %s\n",(*prvy).datum);
			printf("\n");
			i++;
			pocet = 1;
			prvy = (*prvy).dalsi; 
		}
		else
			prvy = (*prvy).dalsi;

	}
	if (pocet == 0)
		printf("Pre prezentacnu miestnost <%s> niesu prezentujuce osoby.\n",c);
}

void z(struct Osoba **prvy,struct Osoba **druhy,struct Osoba **treti,struct Osoba **stvrty,struct Osoba **piaty,struct Osoba **siesty){
	
	// inspiracia zo stranky codeforwin //
	struct Osoba *hodnota, *phodnota;
	char roc[11];
	hodnota = *prvy;
	
	if(*prvy == NULL){
		return;
	}
	printf("Zadaj rodne cislo\n");
	scanf("%s",&roc);
	
		(**prvy).rc[strlen((**prvy).rc)-1] = '\0';
		(**druhy).rc[strlen((**druhy).rc)-1] = '\0';
		(**treti).rc[strlen((**treti).rc)-1] = '\0';
		(**stvrty).rc[strlen((**stvrty).rc)-1] = '\0';
		(**piaty).rc[strlen((**piaty).rc)-1] = '\0';
		(**siesty).rc[strlen((**siesty).rc)-1] = '\0';
		
		(**prvy).prez[strlen((**prvy).prez)-1] = '\0';
		(**druhy).prez[strlen((**druhy).prez)-1] = '\0';
		(**treti).prez[strlen((**treti).prez)-1] = '\0';
		(**stvrty).prez[strlen((**stvrty).prez)-1] = '\0';
		(**piaty).prez[strlen((**piaty).prez)-1] = '\0';
		(**siesty).prez[strlen((**siesty).prez)-1] = '\0';
	
	if(strcmp((**prvy).rc,roc) == 0){
		hodnota = *prvy;
		printf("Prezenter s menom %s bol vymazany\n",(*hodnota).prez);
		*prvy = (**prvy).dalsi;
		free(hodnota);

	}
	
	hodnota = NULL;
	phodnota = *prvy;
	
	while(phodnota != NULL){
		if(strcmp((*phodnota).rc,roc) == 0){
			if (hodnota != NULL)
				printf("Prezenter s menom %s bol vymazany\n",(*phodnota).prez);
				(*hodnota).dalsi = (*phodnota).dalsi;
			free(phodnota);
			phodnota = (*hodnota).dalsi;
		}
		else{
			hodnota = phodnota;
			phodnota = (*phodnota).dalsi;
		}
	}		
}

void a(struct Osoba *prvy,struct Osoba *druhy,struct Osoba *treti,struct Osoba *stvrty,struct Osoba *piaty,struct Osoba *siesty){
	char roc[11];
	char typm[3];
	int i;
	long long d;
	
	if(prvy == NULL){
		return;
	}
	(*prvy).rc[strlen((*prvy).rc)-1] = '\0';
	(*druhy).rc[strlen((*druhy).rc)-1] = '\0';
	(*treti).rc[strlen((*treti).rc)-1] = '\0';
	(*stvrty).rc[strlen((*stvrty).rc)-1] = '\0';
	(*piaty).rc[strlen((*piaty).rc)-1] = '\0';
	(*siesty).rc[strlen((*siesty).rc)-1] = '\0';
	
	cyklus:
		printf("Zadaj rodne cislo a typ miestnosti\n");
		scanf("%s %s",&roc,&typm);
		d = _atoi64(roc);
		if(d % 11 == 0 && (strcmp(typm,"UP") == 0 ||strcmp(typm,"UD") == 0 || strcmp(typm,"PP") == 0 || strcmp(typm,"PD") == 0)){
		
			if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
			prvy = (*prvy).dalsi;
			if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
			prvy = (*prvy).dalsi;
				if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
			prvy = (*prvy).dalsi;
			if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
			prvy = (*prvy).dalsi;
			if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
			prvy = (*prvy).dalsi;
			if(strcmp((*prvy).rc,roc) == 0){
				(*prvy).typ[strlen((*prvy).typ)-1] = '\0';
				(*prvy).prez[strlen((*prvy).prez)-1] = '\0';
				(*prvy).nazov[strlen((*prvy).nazov)-1] = '\0';
				strcpy((*prvy).typ,typm);
				printf("Prezenter s menom %s bude prezentovat prispevok %s: %s\n",(*prvy).prez,(*prvy).nazov,(*prvy).typ);
			}
		}	
		else{
			printf("Zadane udaje nie su korektne, zadaj novy retazec\n");
			goto cyklus;
		}
			
	
}
void r(struct Osoba **prvy,struct Osoba **druhy,struct Osoba **treti,struct Osoba **stvrty,struct Osoba **piaty,struct Osoba **siesty){
	struct Osoba *p,*q,*r,*s,*t;
	int i = 1,a,b,c;
	p = *prvy;
	
	if(prvy == NULL){
		return;
	}
	printf("Zadaj dve cisla pre vymenu zoznamov\n");
	scanf("%d %d",&a,&b);
	if (a > b){
		c = a;
		a = b;
		b = c;		
	}
	/* pri v�mene jednotky nefunguje spr�vne napr. pri vstupe 1 3 vymen� len jeden vstup, rovnako aj pri vyssich rozdieloch ako 2-5 to nefunguje korektne. Logika, spociva v tom ze musime v zozanme najst obe osoby
	   podla zadaneho cisla, a osoby pred nimi. Osobu pred prvy najdenim linkneme na druheho, osobu pred druhym linkneme na prveho. A nasledne priradime aj linky obom osobam*/
	if(a == b || 0 > a || a > 6 || 0 > b || b > 6 )
		printf("\n");
	else{
		if(a == 1){
		q = *prvy;
		goto krok;
		}
		if (a == 2){
		p = *prvy;
		goto krokk;
		}
		while (i < a-1){
			p = (*p).dalsi;
			i++;
		}
		krokk:
		q = (*p).dalsi;
		krok:
		i = a;
		if (b-a == 1){
			s = (*q).dalsi;
			goto krokkk;
		}
		while(i < b-1){
			r = (*q).dalsi;
			i++;
		}
		s = (*r).dalsi;
		krokkk:
		t = (*s).dalsi;

		if(a == 1){
			(*s).dalsi = (*q).dalsi;
			(*q).dalsi =  t;
			(*r).dalsi = q;
		}
		else{
		
		(*s).dalsi = (*q).dalsi;
		(*q).dalsi = t;
		(*p).dalsi = s;

		if(b-a == 1)
			(*s).dalsi = q;
		else
			(*r).dalsi = q;
		}


		
	}
}

void p(struct Osoba *prvy){
	int a,j;
	struct Osoba *nova, *zatial;
	char b[52];
	char c[12];
	char d[5];
	char e[152];
	char f[202];
	char g[4];
	char h[6];
	char i[10];
	char x[50];
	
	if(prvy == NULL){
		return;
	}
	nova = (struct Osoba*)malloc(sizeof(struct Osoba));
	
	printf("Zadaj cislo zaznamu\n");
	scanf("%d",&a);
	printf("Zadaj prezentera:\n");
	fgets (x, 100, stdin);  // medzikrok, zabrani preskoceniu vstupu o riadok 
	fgets (b, 100, stdin);
	printf("Zadaj rodne cislo:\n");
	fgets (c, 100, stdin);
	printf("Zadaj kod prezentacnej miestnosti:\n");
	fgets (d, 100, stdin);
	printf("Zadaj nazov:\n");
	fgets (e, 100, stdin);
	printf("Zadaj mena:\n");
	fgets (f, 100, stdin);
	printf("Zadaj typ:\n");
	fgets (g, 100, stdin);
	printf("Zadaj cas:\n");
	fgets (h, 100, stdin);;
	printf("Zadaj datum:\n");
	fgets (i, 100, stdin);

	strcpy((*nova).prez,b);
	strcpy((*nova).rc,c);
	strcpy((*nova).kpm,d);
	strcpy((*nova).nazov,e);
	strcpy((*nova).mena,f);
	strcpy((*nova).typ,g);
	strcpy((*nova).cas,h);
	strcpy((*nova).datum,i);
	
	if (a == 0){  
		(*nova).dalsi = prvy;
		prvy = nova;     // Na zaciatok, 0. poziciu to nefunguje //
	}
	
	if(a < 0 || a >= 6){
		while (prvy != NULL && (*prvy).dalsi != NULL){
		
			prvy = (*prvy).dalsi;
		}
		(*prvy).dalsi = nova;
	
	}
	else{
		zatial = prvy;
		for(j = 0;j < a-1;j++){
			zatial = (*zatial).dalsi;		
		}
		(*nova).dalsi = (*zatial).dalsi;
		(*zatial).dalsi = nova;
	}
}
int main(){
	FILE *subor = fopen("konferencny_zoznam.txt","r");   // Nie je poveadne kde sa ma subor otvorit 
	char c;
	struct Osoba *prvy = NULL;
	struct Osoba *druhy = NULL;
	struct Osoba *treti = NULL;
	struct Osoba *stvrty = NULL;
	struct Osoba *piaty = NULL;
	struct Osoba *siesty = NULL;
	struct Osoba *akt = NULL;
	
	printf("Zadavaj pismeno funkcie\n");
	
	while(1){
		scanf("%c",&c);
	switch(c){
		case 'n':
			n(&prvy,&druhy,&treti,&stvrty,&piaty,&siesty,subor);	
			continue;
		case 'h':
			h(prvy);
			continue;
		case 'r':
			r(&prvy,&druhy,&treti,&stvrty,&piaty,&siesty);
			continue;
		case 'a':
			a(prvy,druhy,treti,stvrty,piaty,siesty);
			continue;
		case 'v':
			v(prvy,subor);	
			continue;	
		case 'p':
			p(prvy);
			continue;	
		case 'z':
			z(&prvy,&druhy,&treti,&stvrty,&piaty,&siesty);
			continue;	
		case 'k':
			akt = prvy;
			if(prvy != NULL && druhy != NULL && treti != NULL && stvrty != NULL && piaty != NULL && siesty != NULL){
				while(prvy != NULL){
				akt = prvy;
				prvy = (*prvy).dalsi;
				free(akt);
				}
				
			}
			
			fclose(subor);
			exit(0);			
	}
	}
	return 0;
}


