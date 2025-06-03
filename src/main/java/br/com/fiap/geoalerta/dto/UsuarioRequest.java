package br.com.fiap.geoalerta.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UsuarioRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String user_name;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    private String senha;

    @Email
    @NotBlank
    private String email;

    @Pattern(
            regexp = "^\\(?(11|12|13|14|15|16|17|18|19|" +
                    "21|22|24|" +
                    "27|28|" +
                    "31|32|33|34|35|37|38|" +
                    "41|42|43|44|45|46|" +
                    "47|48|49|" +
                    "51|53|54|55|" +
                    "61|" +
                    "62|64|" +
                    "63|" +
                    "65|66|" +
                    "67|" +
                    "68|" +
                    "69|" +
                    "71|73|74|75|77|" +
                    "79|" +
                    "81|87|" +
                    "82|" +
                    "83|" +
                    "84|" +
                    "85|88|" +
                    "86|89|" +
                    "91|93|94|" +
                    "92|97|" +
                    "95|" +
                    "96|" +
                    "98|99)" +
                    "\\)?[-\\s]?9?\\d{4}[-\\s]?\\d{4}$",
            message = "Telefone inválido. Use um DDD válido e o formato (11) 91234-5678"
    )
    @NotBlank
    private String telefone;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String user_name, String senha, String email, String telefone) {
        this.user_name = user_name;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome é obrigatório") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres") String getUser_name() {
        return user_name;
    }

    public void setUser_name(@NotBlank(message = "O nome é obrigatório") @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres") String user_name) {
        this.user_name = user_name;
    }

    public @NotBlank(message = "A senha é obrigatória") @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatória") @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres") String senha) {
        this.senha = senha;
    }

    public @Email @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotBlank String email) {
        this.email = email;
    }

    public @Pattern(
            regexp = "\\(?("
                    + "11|12|13|14|15|16|17|18|19|"         // SP
                    + "21|22|24|"                           // RJ
                    + "27|28|"                              // ES
                    + "31|32|33|34|35|37|38|"               // MG
                    + "41|42|43|44|45|46|"                  // PR
                    + "47|48|49|"                           // SC
                    + "51|53|54|55|"                        // RS
                    + "61|"                                 // DF
                    + "62|64|"                              // GO
                    + "63|"                                 // TO
                    + "65|66|"                              // MT
                    + "67|"                                 // MS
                    + "68|"                                 // AC
                    + "69|"                                 // RO
                    + "71|73|74|75|77|"                     // BA
                    + "79|"                                 // SE
                    + "81|87|"                              // PE
                    + "82|"                                 // AL
                    + "83|"                                 // PB
                    + "84|"                                 // RN
                    + "85|88|"                              // CE
                    + "86|89|"                              // PI
                    + "91|93|94|"                           // PA
                    + "92|97|"                              // AM
                    + "95|"                                 // RR
                    + "96|"                                 // AP
                    + "98|99"                               // MA
                    + ")\\)?\\s?9[6-9]\\d{3}-\\d{4}",
            message = "Telefone inválido. Use um DDD válido e o formato (11) 91234-5678"
    ) @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Pattern(
            regexp = "\\(?("
                    + "11|12|13|14|15|16|17|18|19|"         // SP
                    + "21|22|24|"                           // RJ
                    + "27|28|"                              // ES
                    + "31|32|33|34|35|37|38|"               // MG
                    + "41|42|43|44|45|46|"                  // PR
                    + "47|48|49|"                           // SC
                    + "51|53|54|55|"                        // RS
                    + "61|"                                 // DF
                    + "62|64|"                              // GO
                    + "63|"                                 // TO
                    + "65|66|"                              // MT
                    + "67|"                                 // MS
                    + "68|"                                 // AC
                    + "69|"                                 // RO
                    + "71|73|74|75|77|"                     // BA
                    + "79|"                                 // SE
                    + "81|87|"                              // PE
                    + "82|"                                 // AL
                    + "83|"                                 // PB
                    + "84|"                                 // RN
                    + "85|88|"                              // CE
                    + "86|89|"                              // PI
                    + "91|93|94|"                           // PA
                    + "92|97|"                              // AM
                    + "95|"                                 // RR
                    + "96|"                                 // AP
                    + "98|99"                               // MA
                    + ")\\)?\\s?9[6-9]\\d{3}-\\d{4}",
            message = "Telefone inválido. Use um DDD válido e o formato (11) 91234-5678"
    ) @NotBlank String telefone) {
        this.telefone = telefone;
    }
}
