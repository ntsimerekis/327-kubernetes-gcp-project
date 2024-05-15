# Terraform Dynamic Java Application on GKE

## Video Link
https://csulb-my.sharepoint.com/:v:/g/personal/nicholas_tsimerekis01_student_csulb_edu/EQrJz1kdZSxIl5B52POCtKwBdGVade9yhpjA5aLaL3qtGA?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=lPdmMS

## Quickstart

Try out the Terraform in this repository.

### Prerequisites

* The Terraform has only been tested on [Google Cloud Shell](https://cloud.google.com/shell).
* You environment will need:
    * `terraform`
    * `gcloud`
    * `kubectl`
    * `sed`

### Steps

#### 1. Set up Google cloud build to run the dockerfile in backend/.

```
Also be sure to set up the image location correctly in helm charts. api-server.yaml
```

#### 2. Go into the `infra/` folder.

```
cd terraform-example-java-dynamic-point-of-sale/infra
```

#### 3. Change the project name in the terraform.tfvars file

```
project_id = "cecs-327-project"
```

#### 4. Run the Terraform.

```
terraform init
terraform apply
```

#### 5. Destroy the Terraform.

```
terraform destroy
```

You may need to type "Yes", when after you run `terraform apply`.

## License

Apache 2.0 - See [LICENSE](LICENSE) for more information.
