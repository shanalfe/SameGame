
    public void AllCheckColonne () {
        
        int r = 0, i = 0;

        for (i = 0; i < 15; i++) {

            r = RadarColonne (i);
            
            if( (r == 1) && (i!=14) ) {
                CopyColonne(i);
                r = 0;
            }
        }
    }


    /**
    * Méthode RadarColonne
    *   Detecte si une colonne est vide
    * @param j
    */
    public int RadarColonne (int j) {

        int i = 0, v = 1;

        for (i = 0; i < 15; i++) {

            if ( this.tabTerm[i][j] != 'X' )  {

                v = 0;
            } 

            if ( j == 14 ) {
                v = 0;
               
            }
        }
         return v;

    }